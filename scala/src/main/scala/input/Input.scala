package input

/**
  * Created by carlos on 8/3/16.
  */
trait Input {
  def requestInt(f: (Int)=> Boolean) : Int
  def requestString(f: (String => Boolean)) : String
}
