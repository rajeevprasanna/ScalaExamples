package geeksForGeeks.arrays

/**
 * http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array/
 */
object ArrayReversal extends App {
  val array = Array(1, 2, 3, 4, 5)
  val reverseArray = array.reverse
  reverseArray foreach println

  val r = reverseArray(array, 0)
  r foreach println

  def reverseArray(a: Array[Int], tracker: Int): Array[Int] = a match {
    case _ if a.isEmpty => a
    case _ if tracker == a.length / 2 => a
    case _ =>
		      val temp = a(tracker)
		      a(tracker) = a(a.length - tracker - 1)
		      a(a.length - tracker - 1) = temp
		      reverseArray(a, tracker + 1)
  }
}