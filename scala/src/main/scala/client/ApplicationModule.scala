package client

import client.printer.console.{ConsolePrinter, Printer}
import client.printer.{ListView, TaskListView}
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
  bind[Printer] to new ConsolePrinter
  bind[ListView[Seq[Task],Task]] to new TaskListView
}
