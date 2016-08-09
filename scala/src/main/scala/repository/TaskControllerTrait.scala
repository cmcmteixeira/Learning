package repository
import entities.Task

/**
  * Created by carlos on 8/1/16.
  */
trait TaskControllerTrait {
  def create(task: Task): Unit
  def delete(task: Task): Unit
  def update(task: Task): Unit
  def find(title: String): Unit
  def find(title: Int): Unit
}
