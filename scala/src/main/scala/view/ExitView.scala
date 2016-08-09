package view

import controller.RedirectAction
import input.Input
import output.Printer
import scaldi.{Injectable, Injector}

/**
  * Created by carlos on 8/7/16.
  */
class ExitView (implicit inj: Injector) extends View with ChoiceView with Injectable{
  override def input: Input = inject[Input]
  override def printerService: Printer = inject[Printer]

  override def actions: Array[ViewActionPair] = Array[ViewActionPair](
    ViewActionPair("Yes", new RedirectAction {
      override def view: View = throw new Exception
    }),
    ViewActionPair("No", new RedirectAction {
      override def view: View = new InitialView
    })
  )
}
