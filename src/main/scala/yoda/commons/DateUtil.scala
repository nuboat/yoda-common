package yoda.commons

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

trait DateUtil {

  private lazy val fmt = DateTimeFormat.forPattern("yyyyMMdd")

  def isoNOW: Int = fmt.print(today).toInt

  def today: DateTime = DateTime.now()

  def parse(iso: String): DateTime = fmt.parseDateTime(iso)

  def toISO(d: DateTime): Int = fmt.print(d).toInt

  // B.E (Buddhist) -> AD
  def isoBE2AD(iso: Int): Int = {
    val isostr = iso.toString

    if (isostr.length != 8) throw new IllegalArgumentException(
      s"Wrong ISO format : $iso, The expected format should be yyyyMMdd. (25640101) ")

    ((iso / 10000 - 543) * 10000) + (iso % 10000)
  }

  def isoAD2BE(iso: Int): Int = {
    val isostr = iso.toString

    if (isostr.length != 8) throw new IllegalArgumentException(
      s"Wrong ISO format : $iso, The expected format should be yyyyMMdd. (20210101) ")

    ((iso / 10000 + 543) * 10000) + (iso % 10000)
  }

}
