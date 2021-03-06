object PlayWithScala {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val numbers = List(1,2,3)                       //> numbers  : List[Int] = List(1, 2, 3)
  numbers.reverse                                 //> res0: List[Int] = List(3, 2, 1)
  
  type Occurrences = List[(Char, Int)]
  type Word = String
  type Sentence = List[Word]
  
  def wordsOccurences(w: Word): Occurrences = w.toList.groupBy(x => x.toLower).map(_ match {case (letter,matchedLetters) => (letter, matchedLetters.length)}).toList.sortWith(_._1 < _._1)
                                                  //> wordsOccurences: (w: PlayWithScala.Word)PlayWithScala.Occurrences
  wordsOccurences("HELLO WORLD")                  //> res1: PlayWithScala.Occurrences = List(( ,1), (d,1), (e,1), (h,1), (l,3), (o
                                                  //| ,2), (r,1), (w,1))
                                                  
  def sentenceOccurrences(s: Sentence): Occurrences = s match{
    case Nil => Nil
    case sentence => wordsOccurences(sentence.reduceLeft(_+_))
  }                                               //> sentenceOccurrences: (s: PlayWithScala.Sentence)PlayWithScala.Occurrences
  
  sentenceOccurrences(List("hul", "lulz", "fred"))//> res2: PlayWithScala.Occurrences = List((d,1), (e,1), (f,1), (h,1), (l,3), (r
                                                  //| ,1), (u,2), (z,1))
                                                  
                                                  
  val x = "HELLO"                                 //> x  : String = HELLO
  x :: Nil                                        //> res3: List[String] = List(HELLO)
 
 
  
}