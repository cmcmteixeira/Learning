package lib.logger.console

import lib.logger.Logger

/**
  * Created by carlos on 10/7/16.
  */
class ConsoleLogger extends Logger {
  private def format(str:String) = str
  override def warning(file:String, action : String , msg: String): Unit = println(format(msg))
  override def error(file:String, action : String , msg: String): Unit = println(format(msg))
  override def info(file:String, action : String , msg: String): Unit = println(format(msg))
}
