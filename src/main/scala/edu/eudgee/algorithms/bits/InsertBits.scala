package edu.eudgee.algorithms.bits

import scala.annotation.tailrec

object InsertBits {
  //  1100011
  //      10
  // =1100101
  def insert(where: Int, what: Int, shift: Int): Int = {
    val len = binLength(what)
    var maskClear = -1
    maskClear = maskClear ^ get1s(shift)
    maskClear = maskClear | get1s(shift - len)
    val cleared = where & maskClear
    val mask = what << (shift - len)
    cleared | mask
  }

  def binLength(num: Int): Int = {
    @tailrec
    def shift(num: Int, exp: Int): Int = {
      if (math.abs(num) < 2) exp + 1
      else shift(num / 2, exp + 1)
    }

    shift(num, 0)
  }

  @tailrec
  def get1s(len: Int, accum: Int = 1): Int = {
    if (len == 0) 0
    else if (len == 1) accum
    else get1s(len - 1, (accum << 1) + 1)
  }
}
