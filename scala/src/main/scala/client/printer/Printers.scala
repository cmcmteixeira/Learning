package client.printer

import client.task.Task

protected abstract class Printers[T] extends Printer[T]{

}

abstract class ListPrinter[T <: Seq[R],R] extends Printers[T] {
  protected def elemToString(obj: R) : String
}

class TaskListPrinter extends ListPrinter[Seq[Task],Task]{
  protected def printProjectHeader(proj: String): Unit ={
    println(proj)
  }
  implicit override def elemToString(obj: Task): String = {
    s"${obj.id.get} -  ${obj.description.getOrElse("")}"
  }
  override def print(obj: Seq[Task]): Unit = {
    obj.groupBy(_.project).foreach((projectTasks) => {
      printProjectHeader(projectTasks._1.getOrElse(""))
      projectTasks._2.foreach((t:Task) => println(elemToString(t)))
    })
  }
}


