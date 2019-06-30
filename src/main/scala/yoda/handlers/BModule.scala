/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.handlers

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

/**
  * @author Peerapat A on Mar 18, 2017
  */
class BModule extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bindInterceptor[ProfilerInterceptor](methodMatcher = annotatedWith[Profiler])
    bindInterceptor[LocalCacheInterceptor](methodMatcher = annotatedWith[LocalCache])
  }

}
