/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.models

/**
  * @author Peerapat A on Jul 11, 2018
  */
case class JSResponse[T](code: String = "0"
                         , message: String = ""
                         , result: T = null)
