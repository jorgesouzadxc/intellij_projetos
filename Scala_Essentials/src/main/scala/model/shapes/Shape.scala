package model.shapes

sealed trait Shape {

  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color

}

sealed trait Color {

  def red: Double
  def green: Double
  def blue: Double

  def isLight = (red + green + blue) / 3.0 > 0.5
  def isDark = !isLight

}

final case object Red extends Color{

  val red = 1.0
  val green = 0
  val blue = 0

}

final case object Yellow extends Color{

  val red = 1.0
  val green = 1.0
  val blue = 0

}

final case object Pink extends Color {

  val red = 1.0
  val green = 0
  val blue = 1.0

}

final case class CustomColor(red: Double, green: Double, blue: Double) extends Color

case class Circle(radius: Double, color: Color) extends Shape {

  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius

}

sealed trait Rectangular extends Shape {

  def width: Int
  def height: Int
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height

}

case class Rectangle(width: Int, height: Int, color: Color) extends Rectangular

case class Square(size: Int, color: Color) extends Rectangular {

  val width: Int = size
  val height: Int = size

}

object Draw {

  def apply(shape: Shape) = shape match {

    case Rectangle(width, height, color) => s"Retangulo ${Draw(color)} de largura ${width} e altura ${height}"
    case Square(size, color) => s"Quadrado ${Draw(color)} de tamanho ${size}"
    case Circle(radius, color) => s"Circulo ${Draw(color)} de radius ${radius}"

  }

  def apply(color: Color) = {
    color match {

      case Red => "red"
      case Yellow => "yellow"
      case Pink => "pink"
      case color => if (color.isLight) "light" else "dark"

    }
  }

}