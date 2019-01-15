package model.shapes

sealed trait Shape {

  def sides: Int
  def perimeter: Double
  def area: Double

}

sealed trait Color {

  def red(intensity: Double = 1.0)
  def green(intensity: Double = 1.0)
  val blue = 1.0

  def totalColorValue = this.red + this.green + this.blue

  def customColor(red: Double, green: Double, blue: Double) = {

    if (totalColorValue > 3.0 || totalColorValue < 0)
      throw new IllegalArgumentException

    this match {
      case Circle(radius) => new Circle(radius)
      case Square(size) => new Square(size)
      case Rectangle(width, height) => new Rectangle(width, height)
    }

  }

  def lightOrDark: String =
    if (this.totalColorValue > 1.5)
      "Light"
    else
      "Dark"

}

case class Circle(radius: Double) extends Shape with Color {

  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius

}

sealed trait Rectangular extends Shape with Color {

  def width: Int
  def height: Int
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height

}

case class Rectangle(width: Int, height: Int) extends Rectangular

case class Square(size: Int) extends Rectangular {

  val width: Int = size
  val height: Int = size

}