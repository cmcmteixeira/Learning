package view

import controller.Action


/**
  * Created by carlos on 8/1/16.
  */
trait View{
  def render(): Action
}
