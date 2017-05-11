package com.computemachines.geometry

object VectorSpaceOps {
  // def plus[T : Numeric](x: T, y: T): T = {
  //   implicitly[Numeric[T]].plus(x, y)
  // }
  // // def negate[T : Numeric](x:)
  // def times[T : Numeric](x: T, y: T): T = {
  //   implicitly[Numeric[T]].times(x, y)
  // }



  trait Vector2[T] {
    val x: T
    val y: T
    def plus(that: Tuple2[T, T]): Tuple2[T, T]
    def +(that: Tuple2[T, T]) = plus(that)
    def negate: Tuple2[T, T]
    def unary_- : Tuple2[T, T] = negate
    def minus(that: Tuple2[T, T]): Tuple2[T, T] = plus(that.negate)
    def -(that: Tuple2[T, T]) = minus(that)
    // def dot(that: Tuple2[T]): T
    // def times(scalar: T): Tuple2[T]
  }

  implicit def tuple2ToVector2[T : Numeric](tuple: Tuple2[T, T]): Vector2[T] = new Vector2[T] {
    override val (x, y) = tuple
    override def plus(that: Tuple2[T, T]) = (
      implicitly[Numeric[T]].plus(x, that._1),
      implicitly[Numeric[T]].plus(y, that._2)
    )
    override def negate = (
      implicitly[Numeric[T]].negate(x),
      implicitly[Numeric[T]].negate(y)
    )
  }
}
