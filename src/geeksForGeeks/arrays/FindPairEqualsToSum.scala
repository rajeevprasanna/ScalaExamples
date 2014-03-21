package geeksForGeeks.arrays

/**
 * given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
 * Refer : http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
object FindPairEqualsToSum extends App {
  val a = Array(1, 4, 45, 6, 10, -8)
  val sum = 16

  //Method1 : Sort all the elements and move two pointers from start and end till you reach two elements which equals the given sum
  //sort the array
  scala.util.Sorting.quickSort(a)
  println("Array after sorting.......")
  a foreach (i => print(i + "  "))
  println

  //Now move the pointers from both ends
  getEdgeElementSum(a) match {
    case Some(x) => println("Element which makes the given sum exists in array")
    case _ => println("No pair of elements which can sum up the given number are found")
  }

  def getEdgeElementSum(array: Array[Int]): Option[Boolean] = array match {
    case array if array.isEmpty => None
    case array if array.length >= 2 =>
      if (array.head + array.last == sum) {
        println(array.head + " <--->  " + array.last + " can give the sum => " + sum)
        Some(true)
      } else if (array.head + array.last > sum) getEdgeElementSum(array.dropRight(1))
      else getEdgeElementSum(array.drop(1))
    case _ => None
  }

}