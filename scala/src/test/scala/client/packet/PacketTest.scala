package client.packet

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by carlos on 10/10/16.
  */
class PacketTest extends FlatSpec with Matchers{
  "Every packet pror" should " default to None" in {
    val packet = Packet();
   /* packet.index shouldBe None
    packet.action shouldBe None
    packet.description shouldBe None
    packet.project shouldBe None*/
  }
}
