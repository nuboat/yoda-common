/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.utilities

import org.joda.time.{DateTime, DateTimeZone}

/**
  * @author Peerapat A on Oct 8, 2018
  */

object UTCCalendar {

  def today: DateTime = DateTime.now(DateTimeZone.UTC)

}
