package view

import entities.Task

import scala.io.StdIn.{readLine,readInt}

class Console() {
  def sayHello = System.out.println("Hello")

  def getTask : Task = {
    val task : Task = new Task()
    task.title = readLine("Please insert the task title:")
    task.description = readLine("Please insert the task description:")
    task
  }

  def :?(action : String) : Boolean = {
    printf("Do you want to continue %s ? \n 0 - No \n 1 - Yes \n",action)
    if (readInt() equals 0 ) false else true
  }

  def printTask(task : Task) = {
    println("---------------")
    println("-----TASK------")
    println("---------------")
    println()
    println("-----Title-----")
    println(task.title)
    println()
    println("--Description--")
    println(task.description)
  }
}
