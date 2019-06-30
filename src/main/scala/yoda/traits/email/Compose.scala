/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.traits.email

/**
  * @author Peerapat A on Aug 23, 2018
  */
case class Compose(sender: String
                   , from: String
                   , name: String
                   , to: String
                   , cc: Option[String] = None
                   , bcc: Option[String] = None
                   , subject: String
                   , html: String
                   , tags: List[String] = List.empty
                   , attachments: List[Attachment] = List.empty)
