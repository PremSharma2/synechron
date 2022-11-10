package runner

import dictionary.TranslatorApi.translations
import util.Utils.toText

object WordCounter {
  val stream: Stream[String] = Stream.empty[String]

  def addWord(words: String*): Stream[String] = {
    val regex = "[a-z]+".r
    words.flatMap(word => regex.findAllIn(toText(word))).toStream ++ stream

  }

  def updateCount(words: Stream[String]): Map[String, Int] = {

    words.
      foldLeft(Map.empty[String, Int].
        withDefaultValue(0)) {
        case (counts, word) =>
          if (counts.keysIterator.contains(translations(word))) counts.updated(translations(word), counts(translations(word)) + 1) else counts.updated(word, 1)
        case _ => Map.empty[String, Int]

      }

  }

}
