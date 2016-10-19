package client.printer

/**
  * Created by carlos on 10/18/16.
  */
trait View[T] {
  def update(obj: T)
}

trait ListView[T <: Seq[R],R] extends View[T] {
}



