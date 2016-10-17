package client.packet

case class Packet (
                    action: Option[PacketAction.Value] = None,
                    index: Option[Int] = None,
                    description: Option[String] = None,
                    project : Option[String] = None
                  )
