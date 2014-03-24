package grayCode

object GrayCodeWithPositionAndLength extends App {
	
  //Find the exact gray code with given position and length
  val length =3
  val pos = 8
  
  println(generateGrayCode(length, List("0", "1"))(pos-1))
   
  
  def generateGrayCode(length:Int, patterns:List[String]):List[String] = length match {
     case _ if length <= 1 => patterns        						  
     case _ =>  val updated = patterns.map { x => x.concat("0")} ::: patterns.reverse.map{x => x.concat("1") }    			        			 
       			generateGrayCode(length-1, updated)       		  
   }
}