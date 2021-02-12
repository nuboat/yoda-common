package yoda.commons

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.util.Try

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
      s"Wrong ISO format : $iso, The expected format should be yyyyMMdd. (20210101) ")

    (isostr.substring(0, 4).toInt - 543)*10000 + isostr.substring(4).toInt
  }

}
