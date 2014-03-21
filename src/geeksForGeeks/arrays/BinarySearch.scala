package geeksForGeeks.arrays

import scala.annotation.tailrec

object BinarySearch extends App {

  val list = List(1, 2, 4, 5, 6, 8, 9, 25, 31);

  binarySearch(list, 19) match {
    case Some(x) => println("Element found")
    case None => println("Element doesn't exist")
  }

  def binarySearch(list: List[Int], lookupValue: Int) = {
    @tailrec
    def recursion(low: Int, high: Int): Option[Int] = (low + high) / 2 match {
      case _ if high < low => None
      case mid if list(mid) > lookupValue => recursion(low, mid - 1)
      case mid if list(mid) < lookupValue => recursion(mid + 1, high)
      case mid => Some(mid)
    }
    recursion(0, list.length - 1)
  }
}