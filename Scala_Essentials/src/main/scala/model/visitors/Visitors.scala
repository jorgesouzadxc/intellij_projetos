package model.visitors

import java.util.Date

sealed trait Visitors {

  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime() - createdAt.getTime()

}

final case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitors
final case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitors
