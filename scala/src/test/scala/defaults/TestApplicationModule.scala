package defaults

import client.printer.{ListPrinter, TaskListPrinter}
import client.router.Router
import client.task.Task
import lib.dataManager.DataManager
import lib.dataManager.HardDrive.HardDriveDataManager
import lib.logger.Logger
import lib.logger.console.ConsoleLogger
import scaldi.Module

/**
  * Created by carlos on 10/18/16.
  */
object TestApplicationModule {
    def apply(): TestApplicationModule = new TestApplicationModule()
}

class TestApplicationModule extends Module{
    bind[Router] to new Router
    bind[DataManager[Task]] to new HardDriveDataManager[Task]
    bind[Logger] to new ConsoleLogger
    bind[ListPrinter[Seq[Task],Task]] to new TaskListPrinter


    binding identifiedBy 'baseDir to "/tmp/todoApp"
    binding identifiedBy 'fileName to "todo_save"
}
