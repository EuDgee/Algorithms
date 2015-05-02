import edu.eudgee.algorithms.graphs._

val graph = new Graph(4)
graph(0 -> 1)
graph(0 -> 2)
graph(1 -> 3)
graph(2 -> 3)

graph.print()




graph.layers(0)





graph.shortPath(0, 3)
graph.shortPath(0, 1)
