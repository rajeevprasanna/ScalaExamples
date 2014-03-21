package geeksForGeeks.arrays

/**
 * Write an efficient program to find the sum of contiguous sub array within a one-dimensional array of
 * numbers which has the largest sum.
 *
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
object LargestContiguousSubArraySum extends App {

  val a = Array(-2, -3, 4, -1, -2, 1, 5, -3)
  val maxSubSequenceSum = getMaxSubSeqSum(a, 0, 0);
  println("max sum => " + maxSubSequenceSum)

  def getMaxSubSeqSum(a: Array[Int], maxEndingHere: Int, maxSoFar: Int): Int = a match {
    case x if x.isEmpty => maxSoFar
    case _ =>
      val currentSum = maxEndingHere + a.head
      if (currentSum < 0) {
        return getMaxSubSeqSum(a.tail, 0, maxSoFar)
      }
      if (currentSum >= maxSoFar) {
        return getMaxSubSeqSum(a.tail, currentSum, currentSum)
      } else {
        return getMaxSubSeqSum(a.tail, currentSum, maxSoFar)
      }
  }
}