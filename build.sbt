lazy val commonSettings = Seq(
  organization := "com.computemachines",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.10.6"
)

lazy val deform = (project in file("deform")).settings(
  commonSettings,
  name := "scala-physics-deform"
)

// lazy val rigid = (project in file("rigid"))

lazy val root = (project in file(".")).aggregate(deform)