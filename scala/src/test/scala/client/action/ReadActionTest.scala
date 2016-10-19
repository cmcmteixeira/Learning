package client.action

import client.packet.{Packet, PacketAction}
import client.task.Task
import defaults.UnitSpec
import org.scalamock.function.FunctionAdapter1

/**
  * Created by carlos on 10/19/16.
  */
class ReadActionTest extends UnitSpec {
  "The Read Action" should "call the read resources method" in {
      (dataManager.readResource _)
        .expects(*)
        .returns(Nil)

      val deleteAction = new ReadAction(Packet(
        Some(PacketAction.Read)
      )).perform()
  }

}
