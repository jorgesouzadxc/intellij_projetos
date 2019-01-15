package model.shapes

object Draw {

  def apply(shape: Shape) = shape match {

    case Rectangle(width, height) => s"Retangulo de largura ${width} e altura ${height}"
    case Square(size) => s"Quadrado de tamanho ${size}"
    case Circle(radius) => s"Circulo de radius ${radius}"

  }

}
