package client

import scaldi.Module

/**
  * Created by carlos on 10/7/16.
  */
class ConfigurationModule extends Module{
  binding identifiedBy 'baseDir to "/tmp/todoApp"
  binding identifiedBy 'fileName to "todo_save"
}
