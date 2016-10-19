package client.task

import defaults.UnitSpec

/**
  * Created by carlos on 10/19/16.
  */
class TaskTest extends UnitSpec {
  "Two tasks" should "be the same if they have the same ID" in {
    new Task(Some(0)) == new Task(Some(0)) should be(true)
    new Task(Some(0),None,None) == new Task(Some(0),Some(""),Some("")) should be(true)
  }
  it should "have getters and setters" in {
    val t = new Task(
      Some(0),
      Some("desc"),
      Some("proj")
    )
    t.description.get shouldBe "desc"
    t.project.get shouldBe "proj"
    t.id.get shouldBe 0
  }
}
