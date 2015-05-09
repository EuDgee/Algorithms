package edu.eudgee.algorithms.strings

//  1213
//  3435
//  divLen = 1
// = a1 * b1 * 10^(divLen*2) + a1 * b2 * 10^divLen + a2 * b1 * 10^divLen + a2 * b2
// = 12 * 34 * 10^4 + 12 * 35 * 10^2 + 13 * 34 ^ 10^2 + 13 * 35 =
// = 4080000 + 42000 + 44200 + 455 =
// = 4166655
//
//

object BigInt {
  case class Splitted(a1: String, a2: String, b1: String, b2: String, l: Int)
  case class Addition(result: Char, overflow: Boolean)

  val MAX_MULTIPLIABLE = math.pow(2, 15).toInt
  def mul(s1: String, s2: String): String = {
    if (canMultiply(s1, s2)) (s1.toInt * s2.toInt).toString
    else {
      val d = split(s1, s2)
      List(mul10Twice(mul(d.a1, d.b1), d.l),
           mul10(mul(d.a1, d.b2), d.l),
           mul10(mul(d.a2, d.b1), d.l),
           mul(d.a2, d.b2)
      ).reduce((a1, a2) => add(a1, a2))
    }
  }

  def canMultiply(s1: String, s2: String): Boolean = {
    s1.length + s2.length <= 9 // 9 == ((1 << 31) - 1).toString.length - 1
  }

  def mul10(s: String, d10s: Int): String = {
    s + (1 to d10s).map(_ => "0").mkString
  }

  def mul10Twice(s: String, d10s: Int): String = {
    mul10(mul10(s, d10s), d10s)
  }

  def split(s1: String, s2: String): Splitted = {
    val splitLen = math.ceil(math.max(s1.length, s2.length) / 2.0).toInt
    val (a1, a2) = split(s1, splitLen)
    val (b1, b2) = split(s2, splitLen)
    Splitted(a1, a2, b1, b2, splitLen)
  }

  def split(s1: String, len: Int): (String, String) = {
    if (s1.length <= len) ("0", s1)
    else {
      val splitIndex = s1.length - len
      (s1.substring(0, splitIndex), trimStartingZeros(s1.substring(splitIndex)))
    }
  }

  def add(s1: String, s2: String): String = {
    var overflow = false
    trimStartingZeros(s1.reverse.zipAll(s2.reverse, '0', '0').map(c => {
      val (c1, c2) = c
      val a = add(c1, c2)
      val result = if (overflow) add('1', a.result) else a
      overflow = a.overflow || result.overflow
      result.result
    }).reverse.mkString)
  }

  def trimStartingZeros(s: String): String = {
    val zerosLen = s.takeWhile(c => c == '0').length
    if (zerosLen == s.length) "0" else s.substring(zerosLen)
  }

  def add(c1: Char, c2: Char): Addition = {
    val result = c1.toInt - '0' + c2.toInt - '0'
    val a = Addition((result % 10 + '0').toChar, result / 10 != 0)
    a
  }
}
