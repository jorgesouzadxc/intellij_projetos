package model.films_and_directors

case class Film(val name: String
          ,val yearOfRelease: Int
          ,val imdbRating: Double
          ,val director: Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(director: Director) = this.director == director

}

object Film {

  def highestRating(filmA: Film, filmB: Film): Film =
    if (filmA.imdbRating > filmB.imdbRating)
      filmA
    else
      filmB

  def oldestDirectorAtTheTime(filmA: Film, filmB: Film): Director =
    if (filmA.directorsAge > filmB.directorsAge)
      filmA.director
    else
      filmB.director

}
