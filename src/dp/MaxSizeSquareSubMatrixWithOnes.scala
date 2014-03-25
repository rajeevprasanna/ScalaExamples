package dp

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 *
 * Refer: http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
object MaxSizeSquareSubMatrixWithOnes extends App {
  val > = Array
  val matrix: Array[Array[Int]] = >(
    Array(0, 1, 1, 0, 1),
    Array(1, 1, 0, 1, 0),
    Array(0, 1, 1, 1, 0),
    Array(1, 1, 1, 1, 0),
    Array(1, 1, 1, 1, 1),
    Array(0, 0, 0, 0, 0))
  val rows = matrix.length
  val columns = matrix(0).length
  val maxSizeMatrix = Array.ofDim[Int](rows, columns)

  matrix.zipWithIndex.map { c => maxSizeMatrix(c._2)(0) = c._1(0) }
  maxSizeMatrix(0) = matrix(0)

  for (i <- 1 to rows - 1)
    for (j <- 1 to columns - 1) {
      if (matrix(i)(j) == 1) {
        maxSizeMatrix(i)(j) = maxSizeMatrix(i - 1)(j).min(maxSizeMatrix(i - 1)(j)).min(maxSizeMatrix(i - 1)(j - 1)) + 1
      }
    }

  println("Max sub matrix with all ones => " + maxSizeMatrix.flatten.max)
}