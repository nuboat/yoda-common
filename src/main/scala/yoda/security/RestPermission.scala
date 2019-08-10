/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.security

import yoda.definitions.RestMethod.Method

/**
  * @author Peerapat A On Dec 7, 2018
  */
case class RestPermission(method: Method, action: String)
