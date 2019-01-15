package model.films_and_directors

case class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def name = firstName + "" + lastName

}

object Director{

  def older(directorA: Director, directorB: Director): Director =
    if (directorA.yearOfBirth > directorB.yearOfBirth)
      directorB
    else
      directorA

}
