package yoda.commons

import java.util.UUID

trait Uuid {

  def randId(): Long = UUID.randomUUID.getLeastSignificantBits

  def randStrId(): String = UUID.randomUUID.toString.replace("-", "")

  def randREF(len: Int): String = randStrId().substring(2, 2 + len).toUpperCase()

  def randOTP(len: Int): String = randId().toString.substring(2, 2 + len)

}
