package view.task

import controller.task.CreateTaskAction
import defaults.UnitSpec
import input.Input
import module.TestModule
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import output.Printer
import scaldi.{Injector, Module}

class CreateTaskViewTest extends UnitSpec with MockFactory{

  def getInputAndInjector: (Input,Injector) = {
    val input = mock [Input]
    object CreateTaskModule extends FlatSpec with Module {
      bind [Input] to input
    }
    val inj:Injector = CreateTaskModule :: new TestModule
    (input,inj)
  }

  def getOutputAndInjector: (Printer,Injector) = {
    val printer = mock [Printer]
    object CreateTaskModule extends FlatSpec with Module {
      bind [Printer] to printer
    }
    val inj:Injector = CreateTaskModule :: new TestModule
    (printer,inj)
  }

  "The create view" should "request two strings from the user" in {
    val (input,_inj) = getInputAndInjector
    implicit var inj:Injector = _inj

    input.requestString _ expects * returns "Title"
    input.requestString _ expects * returns "Description"

    val createView = new CreateTaskView()
    createView.render()
  }
  it should "set the parameters correctly" in {
    val (input,_inj) = getInputAndInjector
    implicit var inj:Injector = _inj

    input.requestString _ expects * returns "Title"
    input.requestString _ expects * returns "Description"

    val createView = new CreateTaskView()
    val action = createView.render()
    action.asInstanceOf[CreateTaskAction].task.title should be ("Title")
    action.asInstanceOf[CreateTaskAction].task.description should be ("Description")
  }

  it should "prompt the user" in {
    val (output,_inj) = getOutputAndInjector
    implicit var inj:Injector = _inj
    output.sentence _ expects CreateTaskView.InsertTaskTitle
    output.sentence _ expects CreateTaskView.InsertTaskDescription

    val createView = new CreateTaskView()
    val action = createView.render()
  }
}
