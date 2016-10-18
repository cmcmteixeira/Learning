package client.printer.converters

import client.task.Task

/**
  * Created by carlos on 10/18/16.
  */
object taskToString {
  implicit def taskToString(task: Task) ={
    s"${task.id} - ${task.description}"
  }
}
