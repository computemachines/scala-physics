package com.computemachines.geometry

object Triangulation {
  abstract class Face
  /*
   * (face, edgeindex)
   *     = edgeindex refers to the index of the edge inside face.
   */
  type Edge = Tuple2[Face, Int]

  /*
   * vertices are indexed from 1 to 3 in counter clockwise order.
   * edges are indexed by opposite vertex index
   */
  case class Triangle(
    v1: Vertex2,
    f1: Edge,
    v2: Vertex2,
    f2: Edge,
    v3: Vertex2,
    f3: Edge
  ) extends Face

  // for the purposes of the divide and conquer algorithm, represents
  // a triangle with one vertex at infinity.
  case class Segment(
    v1: Vertex2,
    v2: Vertex2,
    f: Face
  ) extends Face

  def delaunay(vertices: Seq[Vertex2]): Face = ???
}
