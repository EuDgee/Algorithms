package edu.eudgee.algorithms.stacks

import scala.collection.mutable

class MinStack extends mutable.Stack[Int] {
  val minStack = new mutable.Stack[Int]()

  override def push(elem: Int): this.type = {
    super.push(elem)
    if (minStack.length == 0 || minStack.top >= elem) {
      minStack.push(elem)
    }

    this
  }

  override def pop(): Int = {
    val elem = super.pop()
    if (elem == minStack.top) {
      minStack.pop()
    }

    elem
  }

  def min(): Int = {
    minStack.top
  }
}
