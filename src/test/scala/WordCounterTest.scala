import org.scalatest.{FlatSpec, Matchers}
import runner.WordCounter

class WordCounterTest extends FlatSpec with Matchers {

  "wordCounter" should "correctly store the input with considering all obligations " in {
    // Given
    
     val wordCount: WordCounter = WordCounter()
    val input = Seq("flower", "flor", "blume")

    // When
    val outputSummary = wordCount.addWord(input : _*)

    // Then
    outputSummary.size should be(3)
  }



  "WordCounter" should "correctly calculate the number of counts and size of counts should be 1" in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("flower", "flor", "blume")

    // When
    val numberOFWordsAdded = wordCount.addWord(input : _*)
    val outputSummary= wordCount.updateCount(numberOFWordsAdded)

    // Then
    outputSummary.size should be(1)
  }


  "WordCounter" should "correctly calculate the number of counts of word which has same meaning in different language should be 3" in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("flower", "flor", "blume")

    // When
    val numberOFWordsAdded = wordCount.addWord(input : _*)
    val outputSummary= wordCount.updateCount(numberOFWordsAdded)

    // Then
    outputSummary.head._2 should be(3)
  }


  "WordCounter" should "result in no words Added As input was corrupt " in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("1", "2", "2")

    // When
    val outputSummary = wordCount.addWord(input : _*)


    // Then
    outputSummary.size should be(0)
  }



}
