package euler91.main

object Euler91 extends App {
  print(numRightTriangles(50))
  def numRightTriangles(n: Int) : Int = {
    def numRightTrianglesAccumulator(x1: Int, y1: Int, x2: Int, y2: Int, acc: Int) : Int =
      if(x1 > n) numRightTrianglesAccumulator(0, y1 + 1, 1, y1 + 1, acc)
      else if(y1 > n) acc
      else if(x2 > n) numRightTrianglesAccumulator(x1, y1, 0, y2 + 1, acc)
      else if(y2 > n) numRightTrianglesAccumulator(x1 + 1, y1, x1 + 2, y1, acc)
      else numRightTrianglesAccumulator(x1, y1, x2 + 1, y2, acc + (if(isRightTriangle(x1, y1, x2, y2)) 1 else 0))

    def isRightTriangle(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
      ((x1 * x2) + (y1 * y2) == 0
        || (x1 * (x1 - x2)) + (y1 * (y1 - y2)) == 0
        || ((x2 * (x1 - x2)) + (y2 * (y1 - y2))) == 0)

    numRightTrianglesAccumulator(1, 0, 0, 1, 0)
  }
}
