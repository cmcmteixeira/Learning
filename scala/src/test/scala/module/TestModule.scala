package module

import input.Input
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import output.Printer
import scaldi.Module

/**
  * Created by carlos on 8/4/16.
  */
class TestModule extends FlatSpec with MockFactory with Module{

    bind [Printer] to stub[Printer]
    bind [Input] to stub[Input]
}
