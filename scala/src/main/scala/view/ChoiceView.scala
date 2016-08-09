package view

import controller.Action
import input.Input
import output.Printer

/**
  * Created by carlos on 8/3/16.
  */
trait ChoiceView {
  case class ViewActionPair(option:String,action:Action)
  def printerService : Printer
  def actions : Array[ViewActionPair]
  def input : Input

  def render(): Action ={
    printerService.menu(actions.map((actionsTuple) => actionsTuple.option))
    printerService.sentence("Please choose an option:")
    val index = input.requestInt((x:Int) => x > 0 && x < actions.length)
    actions(index-1).action
  }
}
