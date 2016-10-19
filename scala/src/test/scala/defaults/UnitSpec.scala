package defaults

import client.printer.ListView
import client.printer.console.Printer
import client.task.Task
import lib.dataManager.DataManager
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import scaldi.{Injector, Module}

abstract class UnitSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors with MockFactory {
  protected val dataManager = mock[DataManager[Task]]
  protected val printer = mock[Printer]
  protected val taskView = mock[ListView[Seq[Task],Task]]

  implicit var module : Injector =  new Module {
    bind[DataManager[Task]] to dataManager
    bind[Printer] to printer
    bind[ListView[Seq[Task],Task]] to taskView
  } :: TestApplicationModule()

}