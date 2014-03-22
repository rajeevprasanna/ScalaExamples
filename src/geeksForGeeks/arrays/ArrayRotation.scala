package geeksForGeeks.arrays

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * 
 * http://www.geeksforgeeks.org/array-rotation/
 */
object ArrayRotation extends App {
	val array = Array(1, 2, 3, 4, 5, 6, 7)
	val d = 2
	
	//Expected output is : 3 4 5 6 7 <--> 1 2
	val reverseWholeArray = reverseArrayWithInIndexPositions(array, 0, array.length-1)
	val reverseStart = reverseArrayWithInIndexPositions(reverseWholeArray, 0, array.length - d-1)
	val reverseNext = reverseArrayWithInIndexPositions(reverseStart, array.length - d , array.length-1)
	reverseNext foreach println
	
	def reverseArrayWithInIndexPositions(a:Array[Int], start:Int, end:Int):Array[Int] = a match {
	  case _ if a.isEmpty || start >= end ||  start < 0 || end >= a.length => a
	  case _ => val temp = a(start)
	  			a(start) = a(end)
	  			a(end) = temp
	  			reverseArrayWithInIndexPositions(a, start+1, end-1)
	}
}