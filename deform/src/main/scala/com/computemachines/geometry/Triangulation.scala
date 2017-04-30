package com.computemachines.geometry


/** A triangulation of a 2d point set. */
class Triangulation

/** Factory for [[com.computemachines.geometry.Triangulation]] instances.
  * Contains methods for constructing special triangulations from point
  * sets.
  */
object Triangulation {

  type Vertex = (Double, Double)

  /** Returns Delaunay Triangulation of vertex set. */
  def delaunay(vertices: Set[Vertex]) = ???
}
