package edu.eudgee.algorithms

import org.scalacheck.Gen
import org.scalatest._
import org.scalacheck.Prop.forAll


class MergeSortSpec extends FlatSpec with Matchers {
  "A Merge Sort" should "sort a simple array" in {
    val unsortedArray: Array[Int] =
      Array(0, 1, 2)
    val sortedArray: Array[Int] =
      Array(0, 1, 2)
    MergeSort.sort(unsortedArray) should be (sortedArray)
  }

  "A Merge Sort" should "sort another simple array" in {
    val unsortedArray: Array[Int] =
      Array(2, 0, 1)
    val sortedArray: Array[Int] =
      Array(0, 1, 2)
    MergeSort.sort(unsortedArray) should be (sortedArray)
  }

  "A Merge Sort" should "sort any array" in {
    val unsortedArray: Array[Int] =
        Array(2, 123, 45, 34, 235, 3, 53, 34, 3, 0, 34, 345, 1, 346, 54)
    val sortedArray: Array[Int] =
        Array(0, 1, 2, 3, 3, 34, 34, 34, 45, 53, 54, 123, 235, 345, 346)
    MergeSort.sort(unsortedArray) should be (sortedArray)
  }
}
