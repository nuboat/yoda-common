/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

trait ISODateTime {

  private val ISO_SEC = "yyyy-MM-dd HH:mm:ss"
  private val ISO_SEC_TZ = "yyyy-MM-dd HH:mm:ssZ"

  protected val FORMATER_ISO_SEC: DateTimeFormatter = DateTimeFormat.forPattern(ISO_SEC)
  protected val FORMATER_ISO_SEC_TZ: DateTimeFormatter = DateTimeFormat.forPattern(ISO_SEC_TZ)

  private val ISO_MILLIS = "yyyy-MM-dd HH:mm:ss.SSSSSS"
  private val ISO_MILLIS_TZ = "yyyy-MM-dd HH:mm:ss.SSSSSSZ"

  protected val FORMATER_ISO_MILLIS: DateTimeFormatter = DateTimeFormat.forPattern(ISO_MILLIS)
  protected val FORMATER_ISO_MILLIS_TZ: DateTimeFormatter = DateTimeFormat.forPattern(ISO_MILLIS_TZ)

}
