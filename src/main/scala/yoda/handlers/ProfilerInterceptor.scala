/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.handlers

import javax.inject.Inject
import org.aopalliance.intercept.{MethodInterceptor, MethodInvocation}
import yoda.traits.metric.LMetric

/**
  * @author Peerapat A on Mar 18, 2017
  */
private class ProfilerInterceptor extends MethodInterceptor {

  @Inject
  var metric: LMetric = _

  override def invoke(invocation: MethodInvocation): AnyRef = {
    val start = System.currentTimeMillis
    val className = invocation.getMethod.getDeclaringClass.getSimpleName
    val methodName = invocation.getMethod.getName

    try {
      invocation.proceed()
    } finally {
      val end = System.currentTimeMillis
      metric.info(id = null
        , name = className
        , method = methodName
        , start = start
        , end = end)
    }
  }

}
