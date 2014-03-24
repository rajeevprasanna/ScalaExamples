package matrices

object MatrixRotationBy90 extends App {
	val > = Array //adding an alias for array
	val array : Array[Array[Character]] = >(
				> ('*', '*', '*', '^', '*', '*', '*'),
				> ('*', '*', '*', '|', '*', '*', '*'),
				> ('*', '*', '*', '|', '*', '*', '*'),
				> ('*', '*', '*', '|', '*', '*', '*')  
	);

  val m = array.length
  val n = array(0).length
  val rotatedArray = Array.ofDim[Character](n, m)

  for (r <- 0 to m - 1)
    for (c <- 0 to n - 1) {
      rotatedArray(c)(m - r - 1) = array(r)(c)
    }

  for (r <- 0 to n - 1) {
    for (c <- 0 to m - 1) {
      print(rotatedArray(r)(c) + "  ")
    }
    println
  }
	
}