/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.traits.cache

import scala.concurrent.duration.Duration

/**
  * @author Peerapat A on April 13, 2018
  */
trait LCache {

  def get[T: Manifest](key: String): Option[T]

  def set(key: String, value: Any , expiration: Duration): Unit

  def asyncset(key: String, value: Any , expiration: Duration): Unit

}
