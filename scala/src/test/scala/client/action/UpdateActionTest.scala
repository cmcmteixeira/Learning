package client.action

import client.packet.{Packet, PacketAction}
import client.task.Task
import defaults.UnitSpec
import org.scalamock.function.FunctionAdapter2

/**
  * Created by carlos on 10/19/16.
  */
class UpdateActionTest extends UnitSpec {

  "The update action" should "call the dataManager update" in {
    (0 until 4) foreach((index:Int) => {
      (dataManager.updateResource _)
        .expects(new FunctionAdapter2((tOld:Task,tNew:Task) => {
          tNew.description.isDefined && tNew.id.get == tOld.id.get
        }))
        .returns(Some(new Task(Some(index))))

      val update = new UpdateAction(Packet(
        Some(PacketAction.Update),
        Some(index),
        Some("desc"),
        Some("proj")
      ))
      update.perform()
    })
  }
  it should "not fail if None is returned" in {
    (dataManager.updateResource _)
      .expects(*,*)
      .returns(None)
    val updateAction = new UpdateAction(Packet(
      Some(PacketAction.Update),
      Some(0)
    ))
    updateAction.perform()
  }
}
