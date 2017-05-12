package com.computemachines.geometry

/*
 * Vector2[T] is just an alias for Tuple2[T, T]. When I say a type is
 * a Vector2[T], I mean that it is really a Tuple2[T, T] but the
 * implicit conversion (tuple2ToVector2) is visible from where the
 * type is used.
 */
object GeometricVector {
  type Vector2[T] = Tuple2[T, T]

  def plus[T : Numeric](x: Vector2[T], y: Vector2[T]): Vector2[T] =
    new Vector2[T](
      implicitly[Numeric[T]].plus(x._1, y._1),
      implicitly[Numeric[T]].plus(x._2, y._2)
    )
  def negate[T : Numeric](x: Vector2[T]): Vector2[T] =
    new Vector2[T](
      implicitly[Numeric[T]].negate(x._1),
      implicitly[Numeric[T]].negate(x._2)
    )
  def minus[T : Numeric](x: Vector2[T], y: Vector2[T]): Vector2[T] =
    plus(x, negate(y))


  implicit class Vector2Ops[T : Numeric](thisVector: Vector2[T]) {
    val (x, y) = thisVector
    def +(that: Vector2[T]) = plus(thisVector, that)
    def unary_- = negate(thisVector)
    def -(that: Vector2[T]) = minus(thisVector, that)
  }
}

// object VectorSpace {
//   trait Vector2[T] {
//     val x: T
//     val y: T
//   }

//   // case DoubleVector2(val x: Double, val y: Double) extends Vector2[Double]

//   implicit def tuple2ToVector2[T : Numeric](tuple: Tuple2[T, T]): Vector2[T] = new Vector2[T] {
//     override val (x, y) = tuple
//   }
// }
