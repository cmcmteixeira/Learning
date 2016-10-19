package client

import client.printer.{ListPrinter, TaskListPrinter}
import client.router.Router
import client.task.Task
import lib.dataManager.DataManager
import lib.dataManager.HardDrive.HardDriveDataManager
import lib.logger.Logger
import lib.logger.console.ConsoleLogger
import scaldi.Module

class ApplicationModule extends Module {
  bind[Router] to new Router
  bind[DataManager[Task]] to new HardDriveDataManager[Task]
  bind[Logger] to new ConsoleLogger
  bind[ListPrinter[Seq[Task],Task]] to new TaskListPrinter
}
