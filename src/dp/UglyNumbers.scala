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
}