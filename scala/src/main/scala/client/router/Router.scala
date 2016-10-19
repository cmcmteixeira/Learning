package client.router

import client.action._
import client.packet.PacketAction._
import scaldi.Injector

class Router {
    def apply(packet : client.packet.Packet)(implicit inj: Injector) : Action = {
      packet.action match {
        case Some(Add) => new CreateAction(packet)
        case Some(Delete) => new DeleteAction(packet)
        case Some(Read) => new ReadAction(packet)
        case Some(Update) => new UpdateAction(packet)
        case _ @ arg => throw new IllegalArgumentException(s"Action $arg not recognised")
      }
  }
}
