package strings

object Anagrams extends App{
	
  //1. check if two given strings are anagrams or not
  val str1 = "geeksforgeeks"
  val str2 = "forgeeksgeeks"     
  println("are two strings anagrams => " + str1.sorted.equals(str2.sorted))
   
  //given set of strings. group them as anagrams
  val stringSet = Set("cat", "animal", "act", "god", "ate", "eat", "dog")
  stringSet.groupBy(s => s.sorted).foreach(x => println(x._2))
  
   //Permutations of a string
  	val s = "abc"
    val it = s.permutations
    while(it.hasNext) println(it.next)
}