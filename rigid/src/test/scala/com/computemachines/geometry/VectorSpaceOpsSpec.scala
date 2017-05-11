package com.computemachines.geometry

import org.scalatest._
import org.scalatest.prop.PropertyChecks

import com.computemachines.geometry.VectorSpaceOps._

class VectorSpaceOpsSpec extends FlatSpec with PropertyChecks with Matchers{
  "Addition of Vectors" should "be associative" in {
    forAll { (
      a: Tuple2[Int, Int],
      b: Tuple2[Int, Int],
      c: Tuple2[Int, Int]
    ) => a + (b + c) === (a + b) + c
    }
  }
  it should "be commutative" in {
    forAll { (
      a: Tuple2[Int, Int],
      b: Tuple2[Int, Int]
    ) => a + b === b + a
    }
  }
  it should "have inverse" in {
    forAll { (a: Tuple2[Int, Int]) => a + (-a) === (0, 0) }
  }
}
