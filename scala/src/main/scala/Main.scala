import entities.Task
import scaldi.{Injectable, Injector}
import view.{InitialView, View}


/**
  * Created by carlos on 7/4/16.
  */
object Main extends Injectable{
  def main(args: Array[String]) {
    var tasks : Array[Task] = new Array[Task](0)

    implicit val inj:Injector = new ApplicationModule
    val initView = inject[InitialView]
    var view:View = initView
    while(true){
      val action = view.render()
      view = action.perform()
    }
  }
}

