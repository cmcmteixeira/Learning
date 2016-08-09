package output

/**
  * Created by carlos on 8/1/16.
  */
trait Printer{
  def menu(options : Array[String])
  def sentence(str : String): Unit
}
