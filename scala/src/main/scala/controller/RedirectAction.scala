package controller

import view.View

/**
  * Created by carlos on 8/4/16.
  */
trait RedirectAction extends Action {
  def view : View
  override def perform(): View = view
}
