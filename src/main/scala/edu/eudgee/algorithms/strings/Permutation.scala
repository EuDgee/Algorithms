package edu.eudgee.algorithms.strings

import scala.annotation.tailrec

object Permutation {
  def isPermutation(s1: String, s2: String): Boolean = {
    if (s1 != s2) {
      isSwapped(s1, s2) || isDifferByOneChar(s1, s2)
    } else {
      false
    }
  }

  def isDifferByOneChar(s1: String, s2: String): Boolean = {
    if (s1.length - s2.length == 1) {
      _isDifferByOneChar(s1, s2)
    } else if (s2.length - s1.length == 1) {
      _isDifferByOneChar(s2, s1)
    } else {
      false
    }
  }

  private def _isDifferByOneChar(s1: String, s2: String): Boolean = {
    val index = findDifference(s1, s2, 0)
    index > 0 && s1.substring(index + 1) == s2.substring(index)
  }

  @tailrec
  def findDifference(s1: String, s2: String, i: Int): Int = {
    if (s1.charAt(i) != s2.charAt(i)) {
      i
    } else if (i < s1.length - 1) {
      findDifference(s1, s2, i + 1)
    } else {
      -1
    }
  }

  def isSwapped(s1: String, s2: String): Boolean = {
    if (s1.length == s2.length) {
      val indices = (0 to s1.length - 1).filter(i => s1.charAt(i) != s2.charAt(i))
      indices.length == 2
    } else {
      false
    }
  }
}
