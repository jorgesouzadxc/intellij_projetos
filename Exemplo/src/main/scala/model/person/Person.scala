package model.person

case class Person (val name: String, val surname: String) {

  def getFullName = name + " " + surname

}

object Person {

  def apply(fullName: String) : Person = {
    val parts = fullName.split(" ")
    new Person(parts(0), parts(1))
  }

  def greet(person: Person): String =
    "Ola, " + person.getFullName

}
