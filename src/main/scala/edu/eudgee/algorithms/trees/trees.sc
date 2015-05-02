import edu.eudgee.algorithms.trees._

//    1
//  2   3
// 4 5

val node5 = TreeNode(None, None)
val node4 = TreeNode(None, None)
val node3 = TreeNode(None, None)

val node2 = TreeNode(Some(node4), Some(node5))
val node1 = TreeNode(Some(node2), Some(node3))

IfBalanced.check(node1)

//      1
//    2   4
//  3
//5

val b5 = TreeNode(None, None)
val b4 = TreeNode(None, None)
val b3 = TreeNode(Some(b5), None)
val b2 = TreeNode(Some(b3), None)
val b1 = TreeNode(Some(b2), Some(b4))

IfBalanced.check(b1)
