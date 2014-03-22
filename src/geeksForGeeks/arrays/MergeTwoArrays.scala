package geeksForGeeks.arrays

/**
 * There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains n elements.
 * Merge these two arrays into the first array of size m+n such that the output is sorted.
 *
 * treat -1 as empty position which can be replaced by element from second array.
 *
 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 *
 */
object MergeTwoArrays extends App {
  val largeArray = Array(2, 8, -1, -1, -1, 13, -1, 15, 20);
  val smallArray = Array(5, 7, 9, 25);
  val updatedArray = mergeSort(largeArray, smallArray, 0, 0)

  updatedArray foreach println

  //Assume b is always small array which will merge into big array a  
  def mergeSort(a: Array[Int], b: Array[Int], aIndexTracker: Int, bIndexTracker: Int): Array[Int] = (a, b) match {
    case (a, _) if a.isEmpty => b
    case (a, b) if b.isEmpty => a
    case (a, b) if aIndexTracker < a.length && bIndexTracker < b.length =>
						      if (a(aIndexTracker) != -1) {
						        mergeSort(a, b, aIndexTracker + 1, bIndexTracker)
						      } else {        
						        a(aIndexTracker) = b(bIndexTracker)
						        mergeSort(a, b, aIndexTracker + 1, bIndexTracker + 1)
						      }
    case (a, _) => a
  }
}