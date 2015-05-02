import edu.eudgee.algorithms.stacks.MinStack

val minStack = new MinStack()
minStack.push(1)
minStack.push(2)

minStack.min()
minStack.pop()
minStack.min()
minStack.pop()

minStack.push(3)
minStack.push(3)
minStack.push(4)
minStack.min()

minStack.pop()
minStack.pop()
minStack.min()
minStack.pop()
