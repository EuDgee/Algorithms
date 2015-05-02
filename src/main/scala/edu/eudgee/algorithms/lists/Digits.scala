package edu.eudgee.algorithms.lists

object Digits {
  type Number = List[Int]

  def add(a: Number, b: Number): Number = {
    val list = a.zipAll(b, 0, 0)
    var left = 0
    val result = list.map(elem => {
      val (a, b) = elem
      val c = a + b + left
      left = c / 10
      c % 10
    })
    if (left != 0) {
      result ++ List(1)
    } else {
      result
    }
  }

  def addDigits(a: Int, b: Int): List[Int] = {
    val c = a + b
    if (c / 10 == 1) {
      List(c, 1)
    } else {
      List(c)
    }
  }
}
