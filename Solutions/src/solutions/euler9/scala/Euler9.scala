package solutions.euler9.scala

import scala.util.control.Breaks._

object Euler9 extends App {
  breakable { for {
    a <- 1 until 1000
    b <- 1 until 1000 - a
    c = 1000 - a - b
    if (a * a) + (b * b) == (c * c)
  } {
      println("a = " + a + ", b = " + b + ", c = " + c + ", product = " + (a * b * c))
      break
  } }
}