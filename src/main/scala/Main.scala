/**
  * Created by Fumiyasu on 2016/05/23.
  */
object Main {

  /**
    * https://gist.github.com/CDillinger/2aa02128f840bdca90340ce08ee71bc2
    * */
  def main(args: Array[String]): Unit = {

    println(fuzzyMatch("aaaa", "bbbb"))
    println(fuzzyMatch("bcd", "abcdef"))
  }

  def fuzzyMatch(stringToSearch: String, pattern: String): Boolean = {
    val patternLength = pattern.length
    val strLength = stringToSearch.length

    def loop(patternIdx: Int, strIdx: Int): Boolean = {
      val first = patternIdx != patternLength && strIdx != strLength
      val second = pattern(patternIdx) == stringToSearch(strIdx)
      (first, second) match {
        case (true, _) => patternLength != 0 && strLength != 0 && patternIdx == patternLength
        case (false, true) => loop(patternIdx + 1, strIdx)
        case (false, false) => loop(patternIdx, strIdx + 1)
      }
    }

    loop(0, 0)
  }

}
