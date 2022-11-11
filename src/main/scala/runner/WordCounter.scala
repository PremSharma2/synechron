package runner

import dictionary.TranslatorApi.{translate, translations}
import util.Utils.toText

case class WordCounter( stream: Stream[String] = Stream.empty) {

  def addWord(words: String*): Stream[String] = {
    val regex = "[a-z]+".r
    words.flatMap(word => regex.findAllIn(toText(word))).toStream ++ stream

  }

  def updateCount(words: Stream[String]): Map[String, Int] = {

    words.
      foldLeft(Map.empty[String, Int].
        withDefaultValue(0)) {
        case (counts, word) =>
          if (counts.keysIterator.contains(translate(word))) counts.updated(translate(word), counts(translate(word)) + 1) else counts.updated(word, 1)

      }

  }

}
