package lib.logger

trait Logger {
  def warning(_class:String, action : String , msg: String)
  def error(_class:String, action : String , msg: String)
  def info(_class:String, action : String , msg: String)
}
