/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.models

/**
  * @author Peerapat A on May 26, 2018
  */
case class KnownException(code: String
                          , message: String
                          , cause: Throwable = null)

  extends RuntimeException(message, cause)
