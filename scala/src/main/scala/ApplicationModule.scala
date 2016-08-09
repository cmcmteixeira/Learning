import input.{ConsoleInput, Input}
import output._
import scaldi.Module
import view.InitialView

class ApplicationModule extends Module {
  bind [Printer] to new ConsoleFormattedPrinter
  bind [InitialView] to new InitialView
  bind [Input] to new ConsoleInput
}