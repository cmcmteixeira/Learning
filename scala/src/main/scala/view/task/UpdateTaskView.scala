package view.task

import controller.Action
import controller.task.UpdateTaskAction
import input.Input
import output.Printer
import scaldi.{Injectable, Injector}
import view.View

class UpdateTaskView(implicit inj: Injector) extends View with Injectable{
  private val input_ = inject[Input]
  private val formatterService_ : Printer = inject [Printer]

  override def render(): Action = {
    val task:(String,String) = ("","")
    formatterService_.sentence("Insert the task id:")
    val id = input_.requestString((x:String ) => x.length > 0)
    new UpdateTaskAction()
  }


}