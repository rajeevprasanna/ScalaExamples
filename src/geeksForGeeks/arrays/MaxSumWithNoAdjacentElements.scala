package geeksForGeeks.arrays

/*	
	Using Dynamic Programming : you have to maintain an array maxsum[] such that maxsum[i] has the maximum sum till the ith element. and
	
	maxsum[i]=max(maxsum[i-2],maxsum[i-3])+arr[i];
	and the catch is that we have to include either the 1st element or the 2nd element in the maxsum
	so
	maxsum[0]=arr[0];
	maxsum[1]=arr[1];
	maxsum[2]=arr[0]+arr[2];
	now apply the recursive structure from the 4th element onwards.
	
	Refer :  http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
object MaxSumWithNoAdjacentElements extends App {
  val inputArray = Array(5, 15, 10, 40, 50, 35)

  //Approach 1 :
  val maxSumHolder = new Array[Int](inputArray.length)
  maxSumHolder(0) = inputArray(0)
  maxSumHolder(1) = inputArray(1)
  maxSumHolder(2) = (inputArray(0) + inputArray(2)) max inputArray(1)
  for (i <- 3 to inputArray.length - 1) {
    maxSumHolder(i) = inputArray(i) + maxSumHolder(i - 2) max maxSumHolder(i - 3)
  }
  println(maxSumHolder(inputArray.length - 1))

  //Approach 2 : 
  val sumList = Array.fill(inputArray.length) { 0 }
  inputArray.zipWithIndex.foreach {
    case (x, i) =>
      if (i == 0 || i == 1) sumList(i) = x
      else if (i == 2) sumList(i) = (inputArray(0) + x) max inputArray(1)
      else if (i >= 3) {
        sumList(i) = (sumList(i - 2) max sumList(i - 3)) + x;
      }
  }  
  println(sumList(inputArray.length - 1)) 

  //Approach3 : Trying without creating an array and using mutable variables
  val n = inputArray.length - 1
  var prevSum = 0
  var curSum = inputArray(0)
  var maxSum = 0
  for (i <- 1 to n) {
    maxSum = curSum.max(prevSum)
    curSum = prevSum + inputArray(i)
    prevSum = maxSum
  }
  println(curSum)

  //Approach4 : try using Scala immutable types
  print(getMaxAlternativeElementSum(0, 0, inputArray(0)))
  def getMaxAlternativeElementSum(tracker: Int, prevSum: Int, curSum: Int):Int = tracker match {
    case _ if tracker == 0  => getMaxAlternativeElementSum(tracker+1, 0, inputArray(tracker))
  	case _ if tracker >= inputArray.length => curSum    
    case _ => val maxSum = curSum.max(prevSum)    		   
    		  getMaxAlternativeElementSum(tracker+1, maxSum, prevSum+inputArray(tracker))
  }
  println
  
  //Approach4: 
  println(getMaxAlternativeElementSum(inputArray))
  def getMaxAlternativeElementSum(input: Array[Int]): Int = {
    val sums =
      input.zipWithIndex.fold((0, 0)) { (acc, elem) =>
        elem._2 % 2 match {
          case 0 => (acc._1 + elem._1, acc._2)
          case 1 => (acc._1, acc._2 + elem._1)
        }
      }
    if (sums._1 > sums._2) sums._1 else sums._2
  } 
  
}