package lib.logger.console

import java.io.ByteArrayOutputStream

import client.printer.console.ConsolePrinter
import defaults.UnitSpec

/**
  * Created by carlos on 10/20/16.
  */
class ConsoleLoggerTest extends UnitSpec {
  "The Console Logger" should "print all messages" in {
    val logger = new ConsoleLogger
    val testStr = "teste_str"
    val methods = Seq(
      logger.error _,
      logger.info _,
      logger.warning _
    )
    methods.foreach {
      case(fun) =>
        val out = new ByteArrayOutputStream()
        Console.withOut(out){
          fun.apply(
            testStr,
            testStr,
            testStr
          )
          out.toString should include regex s""".*$testStr.*"""
        }
    }
  }
}
