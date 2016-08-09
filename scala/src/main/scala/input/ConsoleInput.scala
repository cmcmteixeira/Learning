package input
import scaldi.{Injectable, Injector}

import scala.io.StdIn.{readInt, readLine}
/**
  * Created by carlos on 8/3/16.
  */
class ConsoleInput(implicit inj: Injector) extends Input with Injectable{
  override def requestInt(f: (Int) => Boolean): Int = {
    val x = readInt()
    f(x)
    x
  }
  override def requestString(f: (String) => Boolean): String = {
    val x = readLine()
    f(x)
    x
  }
}
