import entities.Task
import view.Console


/**
  * Created by carlos on 7/4/16.
  */
object Main {
  def main(args: Array[String]) {
    var tasks : Array[Task] = new Array[Task](0)

    val console : Console = new Console
    console.sayHello

    do tasks :+= console.getTask while(console :? "adding tasks" )

    tasks.foreach(console.printTask)
  }
}
