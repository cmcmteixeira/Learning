package client.printer.console


class ConsolePrinter extends Printer{
  override def print(s: String): Unit = println(s)
}
