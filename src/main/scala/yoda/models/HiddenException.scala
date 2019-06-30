/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.models

/**
  * @author Peerapat A on Jul 13, 2018
  */
case class HiddenException(code: String
                           , message: String
                           , cause: Throwable = null)
  extends RuntimeException(message, cause)
