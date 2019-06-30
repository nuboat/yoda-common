/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.utilities

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by Peerapat A on May 19, 2017
  */
trait DateParser {

  private val yyyyMMdd = DateTimeFormat.forPattern("yyyyMMdd")

  def yyyyMMddToDate(d: String): DateTime = yyyyMMdd.parseDateTime(d)

}
