lazy val commonSettings = Seq(
  organization := "ca.brainhouse",
  version := "1.0",
  scalaVersion := "2.11.8"
)

val akkaV       = "2.4.3"
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.0" % "test"
val scalaMock = "org.scalamock" %% "scalamock-scalatest-support" % "3.3.0" % "test"
val elasticSearch = "com.sksamuel.elastic4s" %% "elastic4s-core" % "2.3.0"
lazy val commonDependencies = Seq(
  scalaCheck,
  scalaTest,
  scalaMock,
  elasticSearch,
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-stream" % akkaV,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaV
)


lazy val snowball = (project in file("snowball")).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= commonDependencies
  )


Revolver.settings

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "brainhouse"
  ).
  aggregate(snowball).
  dependsOn(snowball)



fork in run := true
