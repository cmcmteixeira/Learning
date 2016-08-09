package view

import controller.RedirectAction
import input.Input
import output.Printer
import scaldi.{Injectable, Injector}
import view.task.{CreateTaskView, DeleteTaskView, ReadTaskView, UpdateTaskView}

/**
  * Created by carlos on 8/1/16.
  */
class InitialView(implicit inj: Injector) extends View with ChoiceView with Injectable{

  override def actions : Array[ViewActionPair]= Array[ViewActionPair](
    ViewActionPair("Create Task", new RedirectAction {
      override def view: View = new CreateTaskView()
    }),
    ViewActionPair("Read Task", new RedirectAction {
      override def view: View = new ReadTaskView()
    }),
    ViewActionPair("Update Task", new RedirectAction {
      override def view: View = new UpdateTaskView()
    }),
    ViewActionPair("Delete Task", new RedirectAction {
      override def view: View = new DeleteTaskView()
    }),
    ViewActionPair("Exit", new RedirectAction {
      override def view: View = new ExitView()
    })
  )
  override def printerService: Printer = formatterService_
  override def input : Input = input_

  private val input_ = inject[Input]
  private val formatterService_ : Printer = inject [Printer]
}
