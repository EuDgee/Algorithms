package edu.eudgee.algorithms

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}


class MergeSortSpec extends FeatureSpec with GivenWhenThen with Matchers
    with GeneratorDrivenPropertyChecks {

  feature("Merge sort") {
    scenario("Sort simple arrays") {
      Given("simple, already sorted array")
      val alreadySortedArray: Array[Int] = Array(0, 1, 2)
      Then("sort it correctly")
      MergeSort.sort(alreadySortedArray) should be (alreadySortedArray)

      Given("simple, unsorted array")
      val unsortedArray: Array[Int] = Array(2, 0, 1)
      Then("sort it correctly")
      val sortedArray: Array[Int] = Array(0, 1, 2)
      MergeSort.sort(unsortedArray) should be (sortedArray)
    }

    scenario("Sort any array") {
      forAll {(lst: List[Int]) =>
        if (lst.nonEmpty) {
          MergeSort.sort(lst.toArray) should be (lst.sortWith(_ < _).toArray)
        }
      }
    }
  }
}
