package edu.eudgee.algorithms.graphs

import edu.eudgee.algorithms.graphs.Graph._
import scala.collection.mutable
import scala.annotation.tailrec

object Graph {
  type Vertex = Int
  type EndPoints = (Vertex, Vertex)
  type Path = List[Vertex]
  val UNEXPLORED = -1
}

class Graph(numOfVertices: Int) {
  val adjacenciesList = Array.fill(numOfVertices)(mutable.MutableList[Vertex]())

  def apply(points: EndPoints): Unit = {
    val (u, v) = points
    adjacenciesList(u) += v
    adjacenciesList(v) += u
  }

  def print(): Unit = {
    for (i <- 0 to adjacenciesList.length - 1) {
      println(i.toString + "\t" + vertexStr(adjacenciesList(i).toList))
    }
  }

  def vertexStr(list: List[Vertex]): String = {
    list.map(i => " -> " + i + ";").reduce(_ + _)
  }

  def layers(start: Vertex): Array[Vertex] = {
    val startVertex = new mutable.Queue[Vertex]()
    startVertex.enqueue(start)
    layers(startVertex)
  }

  @tailrec
  final def layers(vertices: mutable.Queue[Vertex], layer: Int = 0, array: Array[Int] = Array.fill(numOfVertices)(Graph.UNEXPLORED)): Array[Int] = {
    if (vertices.isEmpty) {
      array
    } else {
      val queue = new mutable.Queue[Vertex]()
      vertices.foreach(v => {
        if (array(v) == Graph.UNEXPLORED) {
          array(v) = layer
          queue ++= adjacenciesList(v)
        }
      })

      layers(queue, layer + 1, array)
    }
  }

  def shortPath(start: Vertex, finish: Vertex): Path = {
    val explored = Array.fill(numOfVertices)(false)
    val path = new mutable.Stack[Vertex]().push(start)
    explored(start) = true
    val stack = dfsPath(path, explored, finish)
    val list = new mutable.MutableList[Vertex]()
    (0 to stack.length - 1).foreach(_ => stack.pop() +=: list)
    list.toList
  }

  def getNext(vertex: Vertex, explored: Array[Boolean]): Option[Vertex] = {
    adjacenciesList(vertex).find(v => !explored(v))
  }

  @tailrec
  final def dfsPath(path: mutable.Stack[Vertex], explored: Array[Boolean], finish: Vertex): mutable.Stack[Vertex] = {
    if (path.isEmpty) {
      mutable.Stack()
    } else {
      val vertex = getNext(path.top, explored)
      vertex match {
        case None => {
          path.pop()
          dfsPath(path, explored, finish)
        }
        case Some(v) => {
          explored(v) = true
          path.push(v)
          if (v == finish) {
            path
          } else {
            dfsPath(path, explored, finish)
          }
        }
      }
    }
  }
}
