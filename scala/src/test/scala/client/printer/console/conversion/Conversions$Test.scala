package client.printer.console.conversion

import client.task.Task
import defaults.UnitSpec

/**
  * Created by carlos on 10/19/16.
  */
class Conversions$Test extends UnitSpec {

  "When converting a task to string" should "the task name,project and index should be included" in {
    Conversions.taskToString(new Task(
      Some(0),
      Some("a_task_description"),
      Some("a_project_name")
    )) contains allOf (
      "a_task_description",
      "a_project_name",
      "0"
    )
  }
  it  should "create print an empty string if the project is empty" in {
    Conversions.taskToString(new Task(
      Some(0),
      Some("a_task_description"),
      Some("a_project_name")
    )) contains allOf (
      "a_task_description",
      "0"
    )
  }

}
