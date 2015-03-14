package org.fiser.monad.read

trait UserRepository {
  def get(id: Int): User

  def find(username: String): User
}