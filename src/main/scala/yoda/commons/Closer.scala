/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import scala.language.reflectiveCalls
import scala.util.Try

/**
  * Created by Peerapat A on Mar 18, 2017
  */
trait Closer {

  def closer[T <: {def close(): Unit}, R](resource: T)(block: T => R): R = try {
    block(resource)
  } finally {
    Try(resource.close()).failed foreach { t => println(s"[WARN] ${t.getMessage}")}
  }

}
