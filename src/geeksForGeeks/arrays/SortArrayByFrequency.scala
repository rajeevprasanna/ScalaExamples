package geeksForGeeks.arrays

/**
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came 1st
 *
 * E.g. 2 5 2 8 5 6 8 8 output: 8 8 8 2 2 5 5 6.
 *
 * Refer: http://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
object SortArrayByFrequency extends App {
  val inputArray = Array(2, 5, 2, 8, 5, 6, 8, 8)
  inputArray.groupBy(x => x).foreach { a =>
    a._2.foreach(println)
  }
}