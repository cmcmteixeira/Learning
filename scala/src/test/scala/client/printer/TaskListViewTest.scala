package client.printer

import client.task.Task
import defaults.UnitSpec

import scala.util.Random

/**
  * Created by carlos on 10/19/16.
  */
class TaskListViewTest extends UnitSpec {
  val taskPerProj = 10
  val seq = (0 to 5).flatMap((index: Int) => {
    0 to taskPerProj map ((taskIndex: Int) => {
      new Task(
        Some(index * taskPerProj + taskIndex),
        Some(s"descrition$index"),
        Some(s"project$index")
      )
    })
  })

  "The task list view" should "call the printer with a sorted (by project) seq" in {
    import client.printer.console.conversion.Conversions.taskToString
    seq.groupBy(_.project).foreach {
      case (Some(proj), tasks) => {
        (printer.print _).expects(proj)
        tasks.foreach((t: Task) => {
          (printer.print _).expects(taskToString(t))
        })
      }
    }
    new TaskListView().update(Random.shuffle(seq))
  }
}
