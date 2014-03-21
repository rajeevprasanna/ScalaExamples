package geeksForGeeks.arrays

/**
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times.
 *
 * Find the number in O(n) time & constant space
 *
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
object OddOccuredElement extends App {
  val a = Array(1, 2, 3, 2, 3, 1, 3);

  //Do xor with all elements of array and remaining element will be the odd times occurred element
  val oddOccurredElement = a.foldLeft(0)(_ ^ _)
  println(oddOccurredElement)
}