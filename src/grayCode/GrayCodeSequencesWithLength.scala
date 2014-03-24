package grayCode

object GrayCodeSequencesWithLength extends App {
	//print all gray code sequences with given length
       
   generateGrayCode(2, List("0", "1")) foreach println
   
   def generateGrayCode(length:Int, patterns:List[String]):List[String] = length match {
     case _ if length <= 1 => patterns        						  
     case _ =>  val updated = patterns.map { x => x.concat("0")} ::: patterns.reverse.map{x => x.concat("1") }    			        			 
       			generateGrayCode(length-1, updated)       		  
   }
}