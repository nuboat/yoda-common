/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.security

/**
  * @author Peerapat A on Mar 18, 2017
  */
case class AuthenticationToken(token: String
                               , roleId: Int
                               , accountId: Long)