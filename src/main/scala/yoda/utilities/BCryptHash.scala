/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.utilities

import org.mindrot.jbcrypt.BCrypt

/**
  * Created by Peerapat A on May 11, 2017
  */
object BCryptHash {

  def encrypt(txt: String): String = txt match {
    case null | "" => throw new IllegalArgumentException("Text cannot Empty.")
    case _ => BCrypt.hashpw(txt, BCrypt.gensalt())
  }

  def unMatch(plaintext: String, ciphertext: String): Boolean = !isMatch(plaintext, ciphertext)

  def isMatch(plaintext: String, ciphertext: String): Boolean = (plaintext, ciphertext) match {
    case (null,null) | (null, "") | ("", null) | ("", "") => false
    case _ => BCrypt.checkpw(plaintext, ciphertext)
  }

}
