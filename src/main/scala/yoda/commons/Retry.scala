/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.{Failure, Success, Try}

/**
  * Created by Peerapat A on June 4, 2017
  */
trait Retry {

  @annotation.tailrec
  final def retry[A](limit: Int
                     , count: Int = 1
                     , backoff: Duration = 5 seconds)(f: => A): A = Try(f) match {
    case Success(x) => x

    case Failure(e) =>
      println(s"[WARN] Failed $count / $limit times")

      if (count < limit) {
        Thread.sleep(backoff.toMillis)
        retry(limit, count + 1, backoff)(f)
      } else {
        throw new RuntimeException(s"Reach Retry limit $count times", e)
      }
  }

}
