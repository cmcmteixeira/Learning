package client.printer.console.conversion

import client.task.Task

/**
  * Created by carlos on 10/19/16.
  */
object Conversions {
  implicit def taskToString(t:Task) :String = s"${t.id.get} -  ${t.description.getOrElse("")}"
}
