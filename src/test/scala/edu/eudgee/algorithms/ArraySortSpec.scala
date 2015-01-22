package edu.eudgee.algorithms

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}


class ArraySortSpec extends FeatureSpec with GivenWhenThen with Matchers
    with GeneratorDrivenPropertyChecks {

  feature("Merge sort") {
    testArraySort(MergeSort.sort)
  }

  feature("Quick sort") {
    testArraySort(QuickSort.sort)
  }

  def testArraySort(func: Array[Int] => Array[Int]) {
    scenario("Sort simple arrays") {
      info("simple, already sorted array")
      val alreadySortedArray: Array[Int] = Array(0, 1, 2)
      func(alreadySortedArray) should be (alreadySortedArray)

      info("simple, unsorted array")
      val unsortedArray: Array[Int] = Array(2, 0, 1)
      val sortedArray: Array[Int] = Array(0, 1, 2)
      func(unsortedArray) should be (sortedArray)
    }

    scenario("Sort any array") {
      forAll {(lst: List[Int]) =>
        if (lst.nonEmpty) {
          func(lst.toArray) should be (lst.sortWith(_ < _).toArray)
        }
      }
    }
  }
}
