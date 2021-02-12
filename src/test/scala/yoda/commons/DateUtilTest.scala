/*
 * Copyright (c) 2021. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import org.scalatest.funsuite.AnyFunSuite

/**
  * @author Peerapat (Norbor)
  */
class DateUtilTest extends AnyFunSuite
  with DateUtil {

  test("1. Convert 25640101 -> 20210101") {
    assert(isoBE2AD(25640101) === 20210101)
  }

  test("2. Convert 20210101 -> 25640101") {
    assert(isoAD2BE(20210101) === 25640101)
  }

}
