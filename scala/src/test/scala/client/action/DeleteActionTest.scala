package client.action

import client.packet.{Packet, PacketAction}
import client.task.Task
import defaults.UnitSpec
import org.scalamock.function.FunctionAdapter1

/**
  * Created by carlos on 10/19/16.
  */
class DeleteActionTest extends UnitSpec {

  "The delete action" should "call the dataManager deleteManager" in {
    (0 until 4) foreach((index:Int) => {
      (dataManager.deleteResource _)
        .expects(new FunctionAdapter1((t:Task) => {t.id.get == index}))
        .returns(Some(new Task(Some(index))))

      val deleteAction = new DeleteAction(Packet(
        Some(PacketAction.Delete),
        Some(index)
      ))
      deleteAction.perform()
    })
  }
  it should "not fail if None is returned" in {
    (dataManager.deleteResource _)
      .expects(*)
      .returns(None)
    val deleteAction = new DeleteAction(Packet(
      Some(PacketAction.Delete),
      Some(0)
    ))
    deleteAction.perform()
  }
}
