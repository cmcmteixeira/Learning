package output
import scaldi.{Injectable, Injector}

import scala.Console._

class ConsoleFormattedPrinter(implicit inj: Injector) extends Printer with Injectable{
  private def width = sys.env("COLUMNS").toInt

  private def separator: String ={
    "*" * (this.width - 1) + "\n"
  }

  private def centered(str : String): String = {
    " " * ((width - str.length)/2) + str + "\n"
  }

  private def header(str : String): String = {
    separator + centered(str) + separator
  }

  private def bold(str:String) = YELLOW + str + RESET

  def menu(options : Array[String]): Unit ={
    print(separator)
    options.zipWithIndex.foreach({
      case (option,i) => printf("%s - %s \n",bold((i+1).toString),option)
    })
    print(separator)
  }

  override def sentence(str:String): Unit ={
    print(str)
  }
}
