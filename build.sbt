name := "Brainhouse"
organization := "ca.brainhouse"
version := "1.0"
scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.jcenterRepo

libraryDependencies ++= {
  val akkaV       = "2.4.3"
  val phantomV       = "2.3.0"
  val scalaTestV  = "2.2.6"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV,
    "com.sksamuel.elastic4s" %% "elastic4s-core" % "2.3.0",
    "com.outworkers"  %% "phantom-dsl" % phantomV,
    // "org.allenai.openie" %% "openie" % "4.2.6",
    "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  )
}

javaOptions += "-Xmx4G"
javaOptions += "-XX:+UseConcMarkSweepGC"

Revolver.settings

fork in run := true
