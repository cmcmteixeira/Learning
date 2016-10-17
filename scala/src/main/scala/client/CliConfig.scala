package client

import client.packet.{Packet, PacketAction}

object CliConfig{
  def apply() = {
    new scopt.OptionParser[Packet]("todo"){
      cmd("add")
        .action((_,c) => c.copy(action = Some(PacketAction.Add)))
        .text("Adds a new task to the todo list")
        .children(
          opt[String]("description")
            .abbr("d")
            .text("the task description")
            .action((v,c) => c.copy(description = Some(v)))
            .required(),
          opt[String]("project")
            .abbr("p")
            .text("the task category")
            .action((v,c) => c.copy(project = Some(v)))
            .maxOccurs(1)
        )
      cmd("delete")
        .action((_,c) => c.copy(action = Some(PacketAction.Delete)))
        .text("Deletes a task")
        .children(
          opt[Int]("index")
            .abbr("i")
            .text("the index to be removed")
            .action((v,c) => c.copy(index = Some(v)))
            .required()
        )
      cmd("read")
        .action((_,c) => c.copy(action = Some(PacketAction.Read)))
        .text("Read a task")

    }
  }
}

