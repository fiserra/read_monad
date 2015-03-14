val triple = (i: Int) => i * 3

triple(3)

val triplePlus2 = triple andThen (i => i + 2)
triplePlus2(2)

val f = triplePlus2 andThen (i => i.toString)

f(8)

import scalaz.Reader

val double = Reader[Int, Int]((i: Int) => i * 2)

val doublePlus3: Reader[Int, Int] = double map (i => i + 3)
doublePlus3(3)
