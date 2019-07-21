/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.proxy.email

/**
  * @author Peerapat A on Aug 23, 2018
  */
trait Sender {

  def send(compose: Compose): Result

}