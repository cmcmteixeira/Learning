package client.printer.console

import java.io.{ByteArrayOutputStream, PrintStream}

import defaults.UnitSpec

/**
  * Created by carlos on 10/20/16.
  */
class ConsolePrinterTest extends UnitSpec {
  "The console printer" should "print to STDIN" in {
    val out = new ByteArrayOutputStream()
    Console.withOut(out){
      val printer = new ConsolePrinter
      val testStr = "This_is_a_test"
      printer.print(testStr)
      out.toString should include regex s""".*$testStr.*"""
    }
  }
}
