/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.generator

import akka.actor.Actor

/**
  * Created by Peerapat A on Aug 1, 2017
  */
private[generator] case class RandomUuidActor() extends Actor {

  override def receive: Actor.Receive = {
    case message: Message => message.create()
  }

}