package org.fiser.monad.read

import scalaz.Reader

object Main extends App {
  val userRepository = new UserRepository {
    override def get(id: Int): User = User(1, "rfiser", "Radu", "Fiser", "radu.fiser@gmail.com", 1)
    override def find(username: String): User = User(1, username, "Radu", "Fiser", "radu.fiser@gmail.com", 1)
  }

  private def run[A](reader: Reader[UserRepository, A]): A = {
    reader(userRepository)
  }

  println(run(UserInfo.userEmail(1)))
}
