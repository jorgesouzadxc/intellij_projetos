package main
import model.cats.Cat
import model.counter.Counter
import model.films_and_directors.{Dad, Director, Film}
import model.person.Person
import model.shapes.{Circle, Draw, Rectangle, Square}
import model.visitors.{Anonymous, User, Visitors}

object Main extends App {

  val Oswald = new Cat("Oswald","Black", "Milk")
  val Henderson = new Cat("Henderson", "Ginger", "Chips")
  val Quentin = new Cat("Quentin", "Tabby and white", "Curry")

  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan: Director = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  println(eastwood.yearOfBirth) // should be 1930
  println(dieHard.director.name) // should be "John McTiernan"
  println(invictus.isDirectedBy(nolan)) // should be false
  println(invictus.isDirectedBy(eastwood))

  highPlainsDrifter.copy(name = "L'homme des hautes plaines") // returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
  thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926)) // returns Film("The Thomas Crown Affair", 1926, /* etc */)
  inception.copy().copy().copy()

  println(new Counter(10).inc.dec.inc.inc.count)

  println(Director.older(eastwood, nolan).name)

  val pessoa = Person("Jorge Souza")
  val pessoa2 = pessoa.copy(surname = "Silva")
  val pessoa3 = Person("Teste", "Teste")

  println(Person.greet(pessoa))
  println(Person.greet(pessoa2))
  println(Person.greet(pessoa3))

  println(Cat.willServ(Henderson))
  println(Cat.willServ(Oswald))

  println(s"Nota ${Dad.rate(granTorino)}")
  println(s"Nota ${Dad.rate(dieHard)}")
  println(s"Nota ${Dad.rate(inception)}")

  val us1 = new User("kjk", "jorgesouza1996@outlook.com")
  val us2 = new Anonymous("kkk")

  val quad = new Square(100)
  val retang = new Rectangle(220, 440)
  val circ = new Circle(200)

  println(Draw(quad))
  println(Draw(retang))
  println(Draw(circ))

  println(quad.lightOrDark)
  val quad2 = quad.customColor(0.1, 0.5, 0.5)
  println(quad2.lightOrDark)

}
