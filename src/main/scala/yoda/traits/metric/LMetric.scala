package yoda.traits.metric

/**
  * @author Peerapat A on April 13, 2018
  */
trait LMetric {

  def info(id: String
           , name: String
           , method: String
           , start: Long
           , end: Long): Unit

}
