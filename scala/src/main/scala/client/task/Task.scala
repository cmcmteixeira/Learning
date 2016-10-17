package client.task

import lib.dataManager.Resource

@SerialVersionUID(100L)
class Task(_id : Option[Int] = None, _description: Option[String] = None, _project :Option[String] = None) extends Resource with Serializable{
  def ==(task:Task) = {id == task.id}
  def id = _id
  def description = _description
  def project = _project
}
