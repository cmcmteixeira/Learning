package entities
import defaults.UnitSpec

class TaskTest extends UnitSpec {
  "A Task constructor" should "set its properties correctly" in {
    val stack = new Task("title","description")
    stack.title should be ("title")
    stack.description should be ("description")
  }

  it should "create an empty object" in {
    val stack = new Task()
    stack.title should be ("")
    stack.description should be ("")
  }

  it should "work as expected" in {
    val stack = new Task()

    stack.title = "title"
    stack.title should be ("title")

    stack.description = "description"
    stack.description should be ("description")
  }
}
