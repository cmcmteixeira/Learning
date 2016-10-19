package defaults

import client.task.Task
import lib.dataManager.DataManager
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scaldi.{Injector, Module}

abstract class UnitSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors with MockFactory {
  protected val dataManager = mock[DataManager[Task]]

  implicit var module : Injector =  new Module {
    bind[DataManager[Task]] to dataManager
  } :: TestApplicationModule()

}