package controller

import view.View

/**
  * Created by carlos on 8/4/16.
  */
trait Action {
  def perform() : View
}
