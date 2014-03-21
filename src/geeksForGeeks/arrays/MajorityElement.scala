package geeksForGeeks.arrays

/**
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times
 * http://www.geeksforgeeks.org/majority-element/
 */
object MajorityElement extends App {
  val a = Array(2, 2, 3, 5, 2, 2, 6)
  val majorityElement = a.groupBy(x => x).filter(_._2.length > a.length / 2)
  majorityElement.headOption match {
    case Some(x) => println("Majority element is => " + x._1)
    case _ => println("No majority element exist in the array")
  }
}