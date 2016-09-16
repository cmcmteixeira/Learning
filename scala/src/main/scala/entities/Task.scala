package entities

class Task(tTitle:String = "",tDescription: String = "") {
  private var _title  : String = tTitle
  def title = _title
  def title_= (title:String) : Unit = _title = title


  private var _description : String = tDescription
  def description = _description
  def description_= (desc : String ) : Unit = _description = desc
}
