package geeksForGeeks.arrays

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 *
 * http://www.geeksforgeeks.org/find-the-missing-number/
 */
object MissingNumber extends App {
  val a = Array(1, 2, 4, 5, 6)

  //do xor of all elements from 1 to n with given array. missing element will be left   
  val xor1 = a.foldLeft(0)(_ ^ _)
  val result = (1 until a.length + 2).foldLeft(xor1)(_ ^ _)
  println(result)
}

