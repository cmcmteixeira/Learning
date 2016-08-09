package output

/**
  * Created by carlos on 8/1/16.
  */
trait Formatter {

  def width

  def separator: String

  def centered(str: String): String

  def header(str: String): String

  def bold(str: String)

  def menu(options : Array[String])
}
