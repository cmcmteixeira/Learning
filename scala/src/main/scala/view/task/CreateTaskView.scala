package view.task

import controller.Action
import controller.task.CreateTaskAction
import entities.Task
import input.Input
import output.Printer
import scaldi.{Injectable, Injector}
import view.View


class CreateTaskView(implicit inj: Injector) extends View with Injectable{

  private val input_ = inject[Input]
  private val formatterService_ : Printer = inject [Printer]

  override def render(): Action = {
    formatterService_.sentence(CreateTaskView.InsertTaskTitle)
    val title = input_.requestString((x:String ) => x.length > 0)

    formatterService_.sentence(CreateTaskView.InsertTaskDescription)
    val description = input_.requestString((x:String ) => x.length > 0)
    new CreateTaskAction(new  Task(title,description))
  }
}
object CreateTaskView{
  final val InsertTaskTitle = "Insert the task title: "
  final val InsertTaskDescription = "Insert the task description: "
}