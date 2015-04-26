package edu.eudgee.algorithms.graphs

import edu.eudgee.algorithms.graphs.Graph._
import scala.collection.mutable

object Graph {
  type Vertex = Int
  case class Adjacency(v: Vertex, list: mutable.Set[Vertex])
}

case class Graph(adjacencies: List[Adjacency])

class GraphBuilder() {
  val adjacencyList = mutable.MutableList[Adjacency]()

  def printGraph(): Unit = {
    adjacencyList.foreach(printAdjacency)
  }

  def printAdjacency(a: Adjacency): Unit = {
    val head = a.v
    val str = a.list.map(v => head.toString + " -> " + v.toString).reduce((a, b) => a + "; " + b)
    println(str)
  }

  def addEdge(u: Vertex, v: Vertex): Unit = {
    addAdjacency(u, v)
    addAdjacency(v, u)
  }

  def addAdjacency(from: Vertex, to: Vertex): Unit = {
    val adjacency = getAdjacency(from)
    adjacency.list += to
  }

  def createAdjacency(v: Vertex) = {
    val adjacency = Adjacency(v, mutable.Set())
    adjacencyList += adjacency
    adjacency
  }

  def getAdjacency(v: Vertex): Adjacency = {
    adjacencyList.find(a => a.v == v) getOrElse createAdjacency(v)
  }

  def build: Graph = Graph(adjacencyList.toList)
}
