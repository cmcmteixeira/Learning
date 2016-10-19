package client.router

import client.action.Action
import client.packet.{Packet, PacketAction}
import defaults.UnitSpec
/**
  * Created by carlos on 9/26/16.
  */
class Router$Test extends UnitSpec{
  "The application router" should "handle correctly all package types" in {
    PacketAction.values.foreach((action) => {
      val packet = Packet(action = Some(action))
      val ret = (new Router)(packet)
      ret shouldBe a [Action]
    })
  }
  it should "throw an exception if no action is defined" in {
      val packet = Packet(action = None)
      an[IllegalArgumentException] should be thrownBy (new Router)(packet)
  }
}
