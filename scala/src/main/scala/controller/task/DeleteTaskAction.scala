package controller.task

import controller.Action
import scaldi.{Injectable, Injector}
import view.{InitialView, View}


class DeleteTaskAction(implicit inj: Injector) extends Action  with Injectable{
  override def perform(): View = {
    new InitialView()
  }
}
