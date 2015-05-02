package edu.eudgee.algorithms.trees

import scala.collection.mutable

object IfBalanced {
  def getHeights(node: TreeNode): List[Int] = {
    var list = mutable.MutableList[Int]()

    def treeHeight(node: Option[TreeNode], height: Int): Unit = {
      node match {
        case None => list += height
        case Some(x) => {
          treeHeight(x.left, height + 1)
          treeHeight(x.right, height + 1)
        }
      }
    }

    treeHeight(Some(node), 0)
    list.toList
  }

  def check(node: TreeNode): Boolean = {
    val heights = getHeights(node)
    heights.max <= heights.min + 1
  }
}
