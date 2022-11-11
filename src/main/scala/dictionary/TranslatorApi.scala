package dictionary

object TranslatorApi {

  lazy val translations=Map("flower"-> "flower","blume"->"flower","flor"->"flower")

  def translate(word:String)={
    translations(word)
  }

}
