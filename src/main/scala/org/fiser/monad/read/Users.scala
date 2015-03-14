package org.fiser.monad.read

trait Users {

  import scalaz.Reader

  def getUser(id: Int) = Reader((userRepository: UserRepository) =>
    userRepository.get(id)
  )

  def findUser(username: String) = Reader((userRepository: UserRepository) =>
    userRepository.find(username)
  )
}