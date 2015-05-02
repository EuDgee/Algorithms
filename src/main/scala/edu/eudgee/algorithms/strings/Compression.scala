package edu.eudgee.algorithms.strings

import scala.annotation.tailrec

object Compression {
  def sequenceLength(str: String, index: Int): Int = {
    (index + 1 to str.length - 1).
        takeWhile(i => str.charAt(i) == str.charAt(index)).length + 1
  }

  def compress(str: String): String = {
    @tailrec
    def _compress(indexStr: Int, indexArray: Int, array: Array[String]): String = {
      if (indexStr == str.length) {
        array.mkString
      } else if (indexArray > str.length - 3) {
        str
      } else {
        val seqLen = sequenceLength(str, indexStr)
        array(indexArray) = str.charAt(indexStr).toString
        array(indexArray + 1) = seqLen.toString
        _compress(indexStr + seqLen, indexArray + 2, array)
      }
    }

    _compress(0, 0, Array.fill(str.length)(" "))
  }
}
