package client.printer

import client.printer.console.Printer
import client.task.Task
import scaldi.{Injectable, Injector}
import client.printer.console.conversion.Conversions.taskToString


class TaskListView()(implicit inj:Injector) extends ListView[Seq[Task],Task] with Injectable {
  val printer = inject[Printer]

  override def update(obj: Seq[Task]): Unit = {
    obj.groupBy(_.project).foreach((projectTasks) => {
      printer.print(projectTasks._1.getOrElse(""))
      projectTasks._2.foreach((t:Task) => printer.print(t))
    })
  }

}

