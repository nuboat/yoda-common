/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.traits.security

/**
  *
  * @author Peerapat A on Jul 17, 2017
  */
case class Account(id: Long
                   , clientId: Long = 0
                   , email: String
                   , token: String = null
                   , username: String = null
                   , firstName: String = null
                   , lastName: String = null
                   , bio: String = null
                   , isActive: Boolean
                   , isVerify: Boolean
                   , isChangePass: Boolean = false
                   , permissions: Set[String] = Set.empty)
