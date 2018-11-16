package solutions.euler1.scala

object Euler1 extends App {
  var sum = 0
  var i = 1

  for(i <- 1 until 1000 if i % 3 == 0 || i % 5 == 0) {
    sum += i
  }

  println(sum)
}
