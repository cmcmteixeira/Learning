package repository

import entities.Task

/**
  * Created by carlos on 8/1/16.
  */
class TaskController() extends TaskControllerTrait {

  override def create(task : Task) : Unit = {
    println("Should have saved a task")
  }

  override def delete(task : Task) : Unit = {
    println("Should have deleted a task")
  }

  override def update(task : Task) : Unit = {
    println("Should have updated the task")
  }

  override def find(title : String) : Unit = {

  }

  override def find(title : Int) : Unit = {

  }
}
