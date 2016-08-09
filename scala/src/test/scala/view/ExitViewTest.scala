package view

import defaults.UnitSpec
import input.Input
import module.TestModule
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import scaldi.{Injector, Module}

class ExitViewTest extends UnitSpec with MockFactory{

  "The exit view" should "have only two actions" in {
    implicit var inj:Injector = new TestModule
    val initView = new ExitView()
    initView.actions.length should be (2)
  }

  it should "throw an exception if the users chooses to leave" in {
    val input = mock [Input]
    object InitialViewModule extends FlatSpec with Module {
      bind [Input] to input
    }
    implicit var inj:Injector = InitialViewModule :: new TestModule

    val exitView = new ExitView()

    inSequence {
      1 to exitView.actions.length foreach((i:Int) => {input.requestInt _ expects * returns i})
    }
    var action = new ExitView().render()
    an[Exception] should be thrownBy action.perform()

    action = new ExitView().render()
    action.perform() shouldBe an[InitialView]

  }
}
