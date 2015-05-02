package edu.eudgee.algorithms.lists

import scala.collection.mutable

object Unduplicate {
  def unduplicate[T](list: List[T]): List[T] = {
    val newList = mutable.MutableList[T]()
    val set = mutable.HashSet[T]()
    list.foreach(elem => {
      if (!set.contains(elem)) {
        set += elem
        newList += elem
      }
    })

    newList.toList
  }
}
