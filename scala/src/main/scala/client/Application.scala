package client

import client.packet.Packet
import client.router.Router
import scaldi.{Injectable, Injector}

class Application(implicit inj:Injector) extends Injectable{
  val router = inject[Router]
  def start(args : Array[String]): Unit ={
    (CliConfig().parse(args,Packet()) match {
      case Some(packet) => router(packet)
      case None => throw new IllegalArgumentException
    }).perform()
  }
}
