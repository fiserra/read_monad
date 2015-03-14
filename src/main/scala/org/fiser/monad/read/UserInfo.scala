package org.fiser.monad.read

import scalaz.Reader

object UserInfo extends Users {

  def userEmail(id: Int): Reader[UserRepository, String] = {
    getUser(id) map (_.email)
  }

  def userInfo(username: String): Reader[UserRepository, Map[String, String]] =
    for {
      user <- findUser(username)
      boss <- getUser(user.supervisorId)
    } yield Map(
      "fullName" -> s"${user.firstName} ${user.lastName}",
      "email" -> s"${user.email}",
      "boss" -> s"${boss.firstName} ${boss.lastName}"
    )
}