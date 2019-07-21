/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.generator

import java.util.UUID

/**
  * @author Peerapat A
  */
private[generator] case class UniqueId(i: UUID, uuid: UUID) {

  val creator: String = trim(i)

  val value: String = trim(uuid)

  private def trim(uuid: UUID): String = uuid.toString.replace("-", "")

}