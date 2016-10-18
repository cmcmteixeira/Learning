package client.printer

/**
  * Created by carlos on 10/18/16.
  */
trait Printer[T] {
  def print(obj: T)
}

