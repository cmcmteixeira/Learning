package lib.dataManager

trait DataManager[T <: Resource] {
  def createResource(resource:T) : Option[T]
  def readResource(filter: T => Boolean) : Seq[T]
  def updateResource(oldR:T,newR:T) : Option[T]
  def deleteResource(res:T) : Option[T]
}
