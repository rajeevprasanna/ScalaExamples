package geeksForGeeks.arrays

/**
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader.
 *
 *
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 *
 * Refer:  http://www.geeksforgeeks.org/leaders-in-an-array/
 */
object LeadersInArray extends App {
  val inputArray = Array(16, 17, 4, 3, 5, 2)
  val reverse = inputArray.reverse.toList
  
  getLeaders(reverse, -111111)

  def getLeaders(list: List[Int], max: Int): Unit = list match {     
    case head :: Nil => if (head > max) println(head)
    case head :: tail =>
					      if (head > max) {					        
					        getLeaders(tail, head)
					        println(head)
					      } else {
					        getLeaders(tail, max)
					      }
    case _ => println("Control should never come here")
  }

}