package edu.eudgee.algorithms.sort

import scala.collection.mutable.ArrayBuffer

object MergeSort {
  def sort(array: Array[Int]): Array[Int] = {
    if (array.length == 1) {
      array
    } else {
      val divided = divide(array)
      merge(sort(divided._1), sort(divided._2))
    }
  }

  def divide(array: Array[Int]): (Array[Int], Array[Int]) = {
    val dividedBy = array.length / 2
    (array take dividedBy, array takeRight array.length - dividedBy)
  }

  def merge(array1: Array[Int], array2: Array[Int]): Array[Int] = {
    val result = ArrayBuffer[Int]()
    var i = 0
    var j = 0
    while (i < array1.length && j < array2.length) {
      if (array1(i) < array2(j)) {
        result append array1(i)
        i += 1
      } else {
        result append array2(j)
        j += 1
      }
    }

    if (i < array1.length) {
      result appendAll array1.takeRight(array1.length - i)
    } else {
      result appendAll array2.takeRight(array2.length - j).toList
    }

    result.toArray
  }
}
