package dp

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
 * shows the first 11 ugly numbers. By convention, 1 is included.
 * Write a program to find and print the 150th ugly number.
 *
 * Refer: http://www.geeksforgeeks.org/ugly-numbers/
 */
object UglyNumbers extends App {
  var uglyNumbers = List(1)
  val n = 11

  
  //#Approach1 => implemented similar to java code
  
  var i2 = 0;
  var i3 = 0;
  var i5 = 0;

  // initialize three choices for the next ugly numbers
  var next_multiple_2 = uglyNumbers(i2) * 2;
  var next_multiple_3 = uglyNumbers(i3) * 3;
  var next_multiple_5 = uglyNumbers(i5) * 5;

  for (i <- 0 to n) {
    val nextUglyNumber = min(next_multiple_2, next_multiple_3, next_multiple_5)
    uglyNumbers = uglyNumbers :+ nextUglyNumber

    if (nextUglyNumber == next_multiple_2) {
      i2 = i2 + 1
      next_multiple_2 = uglyNumbers(i2) * 2
    }

    if (nextUglyNumber == next_multiple_3) {
      i3 = i3 + 1
      next_multiple_3 = uglyNumbers(i3) * 3
    }

    if (nextUglyNumber == next_multiple_5) {
      i5 = i5 + 1
      next_multiple_5 = uglyNumbers(i5) * 5
    }
  }

  for (uglyNumber <- uglyNumbers)
    print(uglyNumber + "   ")

  def min(a: Int, b: Int, c: Int): Int = (a, b, c) match {
    case _ if (a <= b && a <= c) => a
    case _ if (b <= a && b <= c) => b
    case _ => c
  }
  
  
  println
  
  
   //Approach 2
  def nums:Stream[Int]={
    def go(a:Int, b:Int, c:Int):Stream[Int]={
      val xs = nums.take(a.max(b.max(c))).toArray
      val a2 = 2 *xs(a-1)
      val b3 = 3*xs(b-1)
      val c5 = 5*xs(c-1)
      if (a2 <= b3 && a2 <= c5) a2 #:: go(a + 1, b, c)
      else if (b3 <= a2 && b3 <= c5) b3 #:: go(a, b + 1, c)
      else c5 #:: go(a, b, c + 1)
    }
    (1 #:: go(1, 1, 1)).distinct
  }
  println(nums.take(n).toList)
  
  
  //Approach3
  lazy val ugly:Stream[Int] = 1#::Stream.from(2).filter{ n => 
    ugly.takeWhile(n/2>=).flatten(x => Seq(2,3,5).map(x*)).contains(n)
  }
  println(nums.take(n).toList)
  
  
  //Approach4 => Checking for each number and deciding whether it is ugly number or not using brute force approach
  val primeFactors = Array(2,3,5)
  def uglyNumber(n: Int): Boolean = n match {
    case _ if n == 1 => true
    case _ if n % 5 == 0 => uglyNumber(n / 5)
    case _ if n % 3 == 0 => uglyNumber(n / 3)
    case _ if n % 2 == 0 => uglyNumber(n / 2)
    case _ => false
  }

  def uglynumbers: Stream[Int] = {
    def go(x: Int): Stream[Int] =
      if (uglyNumber(x)) x #:: go(x + 1)
      else go(x + 1)

    go(1)
  }
  println(uglyNumbers.take(n).toList.sorted)
   
  
}