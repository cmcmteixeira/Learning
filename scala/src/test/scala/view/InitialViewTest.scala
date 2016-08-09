package view

import controller.RedirectAction
import defaults.UnitSpec
import input.Input
import module.TestModule
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import output.Printer
import scaldi.{Injector, Module}

class InitialViewTest extends UnitSpec with MockFactory{


  "The initial view" should "return the correct (String,Action) pair" in {
    val input = mock [Input]
    object InitialViewModule extends FlatSpec with Module {
      bind [Input] to input
    }
    implicit var inj:Injector = InitialViewModule :: new TestModule

    val initView = new InitialView()
    inSequence{
      1 to initView.actions.length foreach((x) => {
        input.requestInt _ expects * returns x
      })
    }

    1 to initView.actions.length foreach((i) => {
      val initView = new InitialView()
      val action = initView.render()
      action shouldBe a[RedirectAction]
      val redirectViewClass = initView.actions(i-1).action.asInstanceOf[RedirectAction].view.getClass
      action.asInstanceOf[RedirectAction].view.getClass should be (redirectViewClass)
    })
  }

  it should "print the menu" in {
    val input = mock [Input]
    val printer=mock[Printer]
    object InitialViewModule extends FlatSpec with Module {
      bind [Printer] to printer
      bind [Input] to input
    }
    implicit var inj:Injector = InitialViewModule :: new TestModule
    val initView = new InitialView()

    input.requestInt _ expects * returns math.min(
      math.abs(initView.actions.length),
      math.abs(initView.actions.length-1)
    )
    printer.menu _ expects * atLeastOnce()
    printer.sentence _ expects * atLeastOnce()
    initView.render()
  }
}
