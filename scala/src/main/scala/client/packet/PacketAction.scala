package client.packet

object PacketAction extends Enumeration{
  type PacketAction = Value
  val Add, Delete, Read/*, Update*/ = Value
}
