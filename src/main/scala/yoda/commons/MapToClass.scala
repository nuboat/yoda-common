/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import java.lang.reflect.Field
import scala.reflect._

/**
  * <p>This helper does not support inner class
  *
  * Created by Peerapat A on Mar 21, 2017
  */
trait MapToClass {

  def mapToC[T](vals: Map[String, Any])(implicit cmf: ClassTag[T]): T = {
    val args = cmf.runtimeClass.getDeclaredFields
      .map(f => lookup(vals, f))

    cmf.runtimeClass.getConstructors
      .head.newInstance(args: _*).asInstanceOf[T]
  }

  def lookup(vals: Map[String, Any], f: Field): AnyRef = try {
    vals(f.getName).asInstanceOf[AnyRef]
  } catch {
    case t: Throwable => null
  }

}
