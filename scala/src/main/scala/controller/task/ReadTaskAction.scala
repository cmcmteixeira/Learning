package controller.task

import controller.Action
import scaldi.{Injectable, Injector}
import view.{InitialView, View}


class ReadTaskAction (implicit inj: Injector) extends Action  with Injectable{
  override def perform(): View = {
    new InitialView()
  }
}

