/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.security

/**
  * @author Peerapat A on May 24, 2018
  */
object Access extends Enumeration {

  type Roles = Value

  val NA: Value = Value(0)

  val API: Value = Value(1)

  val Dashboard: Value = Value(2)

}
