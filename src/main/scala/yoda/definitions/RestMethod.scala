/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.definitions

/**
  * @author Peerapat A On Dec 7, 2018
  */
object RestMethod extends Enumeration {

  type Method = Value

  val OPTION: Value = Value(0)

  val GET: Value = Value(1)

  val POST: Value = Value(2)

  val PUT: Value = Value(3)

  val DELETE: Value = Value(4)

}
