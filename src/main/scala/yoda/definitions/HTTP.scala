/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.definitions

import yoda.utilities.Conf

/**
  * @author Peerapat A on April 13, 2018
  */
object HTTP {

  val version = Conf("version", "beta")

  val HEADERS: List[(String, String)] = List(
    "Cache-Control" -> "no-cache"
    , "Version" -> version)

  val IMAGE_JPG = "image/jpg"

  val APPLICATION_JSON = "application/json"

  val APPLICATION_DOWNLOAD = "application/octet-stream"

}
