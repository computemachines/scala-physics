lazy val commonSettings = Seq(
  organization := "com.computemachines",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.10.6",
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
  )
)

lazy val rigid = (project in file("rigid")).settings(
  commonSettings,
  name := "scala-physics-rigid"
)

lazy val deform = (project in file("deform"))
  .dependsOn(rigid).settings(commonSettings,
    name := "scala-physics-deform",
    libraryDependencies += "org.la4j" % "la4j" % "0.6.0"
)

lazy val root = (project in file(".")).aggregate(rigid, deform)
