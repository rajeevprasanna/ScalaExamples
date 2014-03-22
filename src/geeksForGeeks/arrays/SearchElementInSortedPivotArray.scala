package geeksForGeeks.arrays

/**
 * Search an element in a sorted and pivoted array
 *
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose I rotate the sorted array at some pivot unknown to you beforehand. 
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
 * Devise a way to find an element in the rotated array in O(log n) time.
 *
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
object SearchElementInSortedPivotArray extends App {
  val a = Array(3, 4, 5, 1, 2)
  val searchElement = 1
  
  //By using scala Arrays API
  println("Is Element exists in the array => " + a.contains(searchElement))
  
  //Find the pivot point, divide the array in two sub arrays and call binary search
  //the main idea of finding pivot is - for a sorted and pivot array, pivot element is the only element for which next element is smaller than it 
 
  //find the max element index in array
  val maxElementIndex = a.zipWithIndex.maxBy(_._1)._2   
  //Elements upto maxElementIndex position are in increasing order and after that they are in decreasing order
  //Now based on input search in either of the two regions  
}