/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.generator

import java.util.UUID

import akka.actor.{ActorSystem, Props}
import akka.routing.RoundRobinPool
import com.typesafe.scalalogging.LazyLogging
import javax.inject.{Inject, Singleton}
import yoda.utilities.Conf

import scala.collection.mutable
import scala.collection.parallel.CollectionConverters._

/**
  * Created by Peerapat A on Aug 1, 2017
  */
@Singleton
class UuidService @Inject()(system: ActorSystem) extends LazyLogging {

  private val maxPool = Conf.int("actor.randomuuidactor.pool", 128)

  private val stack = mutable.Stack[UniqueId]()

  private val actor = system.actorOf(RoundRobinPool(maxPool).props(Props[RandomUuidActor]))

  private val default = UUID.randomUUID

  List.fill(maxPool)(UUID.randomUUID).par.foreach(create)

  def randomUUID: UUID = random.uuid

  def randomLongId: Long = if (random.i.getLeastSignificantBits % 2 == 0)
    Math.abs(random.uuid.getLeastSignificantBits)
  else
    Math.abs(random.uuid.getMostSignificantBits)

  def randomStringId: String = random.creator + random.value

  def create(i: UUID): Unit = stack.push(UniqueId(i, UUID.randomUUID))

  private def random: UniqueId = try {
    val uniqueId = stack.pop
    actor ! (this, uniqueId)
    uniqueId
  } catch {
    case _: NoSuchElementException =>
      logger.warn("UUID SERVICES PEAK LOAD")
      UniqueId(default, UUID.randomUUID)
  }

}
