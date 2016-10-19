package client.action
import client.packet.{Packet, PacketAction}
import client.task.Task
import defaults.UnitSpec
import org.scalamock.function.FunctionAdapter1

class CreateActionTest extends UnitSpec{

  val description = "description"
  val project = "project"

  "The creation action" should "call the readResource and increment the task index" in {
    val currentMaxIndex = 1
    (dataManager.readResource _)
      .expects(*)
      .returns(Seq(new Task(Some(currentMaxIndex),None,None)))

    (dataManager.createResource _)
      .expects(new FunctionAdapter1((t:Task) => {t.id.get == currentMaxIndex+1}))
      .returns(Some(new Task(
        Some(currentMaxIndex),
        Some(description),
        Some(project)
      )))

    val create = new CreateAction(Packet(
      Some(PacketAction.Delete),
      None,
      Some(description),
      Some(project)
    ))
    create.perform()
  }
  it should "create a task with index 1 if no tasks exist" in {
    (dataManager.readResource _)
      .expects(*)
      .returns(Seq.empty[Task])

    (dataManager.createResource _)
      .expects(new FunctionAdapter1((t:Task) => {t.id.get == 1}))
      .returns(Some(new Task(Some(1),Some(description),Some(project))))

    val create = new CreateAction(Packet(
      Some(PacketAction.Delete),
      None,
      Some(description),
      Some(project)
    ))
    create.perform()
  }


}
