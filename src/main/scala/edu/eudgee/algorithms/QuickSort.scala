package edu.eudgee.algorithms

import scala.collection.mutable

object QuickSort {
  def sort(array: Array[Int]): Array[Int] = {
    if (array.length == 1) {
      array
    } else {
      val buffer = array.toBuffer
      _sort(buffer, 0, array.length)
      buffer.toArray
    }
  }

  def _sort(buffer: mutable.Buffer[Int], from: Int, to: Int) {
    if (to - from > 1) {
      val pivot = from + choosePivot(to - from)
      val newPivot = partitionAroundPivot(buffer, pivot, from, to)
      _sort(buffer, from, newPivot)
      _sort(buffer, newPivot + 1, to)
    }
  }

  def choosePivot(max: Int): Int = {
    math.floor(math.random * max).toInt
  }

  def partitionAroundPivot(buffer: mutable.Buffer[Int], pivot: Int, from: Int, to: Int): Int = {
    val value = buffer(pivot)
    swap(buffer, pivot, from)
    var lessIndex = from
    for (index <- from + 1 to to - 1) {
      if (buffer(index) < value) {
        swap(buffer, lessIndex + 1, index)
        lessIndex += 1
      }
    }

    swap(buffer, from, lessIndex)
    lessIndex
  }

  def swap(buffer: mutable.Buffer[Int], index1: Int, index2: Int): Unit = {
    if (index1 != index2) {
      val temp = buffer(index1)
      buffer(index1) = buffer(index2)
      buffer(index2) = temp
    }
  }
}
