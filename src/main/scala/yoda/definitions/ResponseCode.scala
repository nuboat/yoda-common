/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.definitions

/**
  * 0 - 100 is for standard response code, for any speicific code please start at 1000
  *
  * @author Peerapat A on Jul 11, 2018
  */
object ResponseCode extends Enumeration {

  val Success: Value = Value(0, "Success")

  val DataMissing: Value = Value(101, "Data Missing")

  val InvalidJson: Value = Value(102, "Invalid Json Message")

  val InvalidRequest: Value = Value(103, "Invalid Request Message")

  val UnknowError: Value = Value(100, "Unknown Error")

}
