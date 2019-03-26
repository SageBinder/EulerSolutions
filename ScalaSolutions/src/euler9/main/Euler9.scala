package euler9.main

import scala.util.control.Breaks.{break, breakable}

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
