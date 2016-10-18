import client.{Application, ApplicationModule, ConfigurationModule}
import scaldi.Injector

object Main {
  def main(args: Array[String]): Unit = {
    implicit val injector: Injector = new ApplicationModule :: new ConfigurationModule
    new Application start args
  }
}
