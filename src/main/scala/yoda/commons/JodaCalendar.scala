/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import org.joda.time.{DateTime, DateTimeZone}

/**
  * @author Peerapat A on Oct 8, 2018
  */
object JodaCalendar {

  def now: DateTime = DateTime.now

  def nowUTC: DateTime = DateTime.now(DateTimeZone.UTC)

}
