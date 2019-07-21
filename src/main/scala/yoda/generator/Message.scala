package yoda.generator

/**
  * @author Peerapat A
  */
private[generator] case class Message(service: UuidService, creator: UniqueId) {

  private[generator] def create(): Unit = service.create(creator.i)

}
