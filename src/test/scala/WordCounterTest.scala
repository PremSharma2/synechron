import org.scalatest.{FlatSpec, Matchers}
import runner.WordCounter

class WordCounterTest extends FlatSpec with Matchers {

  "Checkout" should "correctly calculate the value of a shopping cart" in {
    // Given

    val input = Seq("flower", "flor", "blume")

    // When
    val outputSummary = WordCounter.addWord(input : _*)

    // The
    outputSummary.size should be(3)
  }



  "WordCounter" should "correctly calculate the number of counts and size of counts should be 1" in {
    // Given

    val input = Seq("flower", "flor", "blume")

    // When
    val numberOFWordsAdded = WordCounter.addWord(input : _*)
    val outputSummary= WordCounter.updateCount(numberOFWordsAdded)

    // The
    outputSummary.size should be(1)
  }


  "WordCounter" should "correctly calculate the number of counts of word which has same meaning in different language should be 3" in {
    // Given

    val input = Seq("flower", "flor", "blume")

    // When
    val numberOFWordsAdded = WordCounter.addWord(input : _*)
    val outputSummary= WordCounter.updateCount(numberOFWordsAdded)

    // The
    outputSummary.head._2 should be(3)
  }


  "WordCounter" should "result in no words Added As input was corrupt " in {
    // Given

    val input = Seq("1", "2", "2")

    // When
    val outputSummary = WordCounter.addWord(input : _*)


    // The
    outputSummary.size should be(0)
  }



}
