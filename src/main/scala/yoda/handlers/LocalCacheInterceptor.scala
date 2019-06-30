/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.handlers

import com.typesafe.scalalogging.LazyLogging
import javax.inject.Inject
import org.aopalliance.intercept.{MethodInterceptor, MethodInvocation}
import yoda.traits.cache.LCache

import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * @author Peerapat A on Mar 18, 2017
  */
class LocalCacheInterceptor extends MethodInterceptor
  with LazyLogging {

  @Inject
  var lcache: LCache = _

  override def invoke(invocation: MethodInvocation): AnyRef = {
    val annotated = invocation.getMethod.getAnnotation(classOf[LocalCache])
    val prefix = annotated.prefix()
    val key = try {
      formatKey(prefix, invocation)
    } catch {
      case t: Throwable =>
        logger.warn(t.getMessage, t)
        return invocation.proceed()
    }

    val cache = lcache.get[AnyRef](key)
    if (cache.isDefined) {
      logger.debug(s"Cache: $key -> ${cache.get.toString}")
      return cache.get
    }

    val any = invocation.proceed()
    val timeout = annotated.timeout()
    lcache.asyncset(key, any, timeout minutes)
    logger.debug(s"Put: $key -> ${any.toString} to Cache: ")

    any
  }

  def formatKey(prefix: String, invocation: MethodInvocation): String =
    s"""${prefix}_${invocation.getArguments.map(_.toString).mkString("_")}"""

}
