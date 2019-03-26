package euler81.main

import scala.io.Source

object Euler81 extends App {
  print(minimalMatrixPathSum(loadMatrixFromTxt()))

  def minimalMatrixPathSum(matrix: Array[Array[Int]]) : Int = {
    def minimalMatrixPathSumIter(matrix: Array[Array[Int]], diagonal: Int): Int = {
      if(diagonal == 0) {
        matrix(0)(matrix(0).length - 1) + Math.min(matrix(0)(matrix(0).length - 2), matrix(1)(matrix(0).length - 1))
      } else {
        def diagonalReduce(x: Int, y: Int): Unit = {
          if(x >= 0 && y >= 0) {
            matrix(x)(y) +=
              (if(x < matrix.length - 1 && y > 0)
                Math.min(matrix(x + 1)(y), matrix(x)(y - 1))
              else if(y > 0)
                matrix(x)(y - 1)
              else if(x < matrix.length - 1)
                matrix(x + 1)(y)
              else
                0)
            diagonalReduce(x - 1, y - 1)
          }
        }
        diagonalReduce(
            Math.min(diagonal, matrix.length - 1),
            Math.min(matrix(0).length - 1, matrix(0).length - (diagonal - (matrix.length - 1)) - 1))
        minimalMatrixPathSumIter(matrix, diagonal - 1)
      }
    }
    minimalMatrixPathSumIter(matrix, matrix.length + matrix(0).length - 3)
  }

  def loadMatrixFromTxt(): Array[Array[Int]] = {
    val matrix = Array.ofDim[Int](80, 80)
    for((line, invY) <- Source.fromFile("ScalaSolutions/src/euler81/resources/matrix.txt").getLines().zipWithIndex;
        (strNum, x) <- line.split("\\,").zipWithIndex) {
      matrix(x)(matrix(0).length - 1 - invY) = Integer.parseInt(strNum)
    }
    matrix
  }
}
