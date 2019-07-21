/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.security

/**
  * @author Peerapat A on Jun 1, 2017
  */
trait AuthorizationManager {

  def lookupAccess(token: String): Option[AuthenticationToken]

  def lookupAccount(access: Option[AuthenticationToken]): Option[Account]

  def hasAccess(permission: Permission
                , role: Access.Roles
                , account: Option[Account]): Boolean

}
