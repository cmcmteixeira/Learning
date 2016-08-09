package controller.task

import controller.Action
import entities.Task
import scaldi.{Injectable, Injector}
import view.{InitialView, View}


class CreateTaskAction(_task: Task)(implicit inj: Injector) extends Action  with Injectable{
  def task = _task

  override def perform(): View = {
    new InitialView()
  }
}
