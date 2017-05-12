package com.computemachines.geometry

import org.scalatest._
import org.scalatest.prop.PropertyChecks

// import com.computemachines.geometry.VectorSpace._
import com.computemachines.geometry.GeometricVector._

class GeometricVectorSpec extends FlatSpec with PropertyChecks with Matchers{
  "Addition of Vectors" should "be associative" in {
    forAll { (
      a: Tuple2[Int, Int],
      b: Tuple2[Int, Int],
      c: Tuple2[Int, Int]
    ) => a + (b + c) === (a + b) + c
    }
    forAll { (
      a: Tuple2[Double, Double],
      b: Tuple2[Double, Double],
      c: Tuple2[Double, Double]
    ) => a + (b + c) != (a + b) + c + (0.0, 0.1)
    }
  }
  it should "be commutative" in {
    forAll { (
      a: Tuple2[Int, Int],
      b: Tuple2[Int, Int]
    ) => plus(a, b) === plus(b, a)
    }
    forAll { (
      a: Tuple2[Double, Double],
      b: Tuple2[Double, Double]
    ) => plus(a, b) === plus(b, a)
    }
  }
  // it should "have inverse" in {
  //   forAll { (a: Tuple2[Int, Int]) => a + (-a) === (0, 0) }
  // }
}
