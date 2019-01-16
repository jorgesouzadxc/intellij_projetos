package model.cats

case class Cat(name: String, colour: String, food: String) extends Feline {
  override def sound: String = "meow"
}

object Cat {

  def willServ(cat: Cat): Boolean =
    cat match {
      case Cat(_, _, food) => food.toLowerCase == "chips"
    }

}