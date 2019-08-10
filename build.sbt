organization := "in.norbor"

name := "yoda-common"

version := "0.4.0"

scalaVersion := "2.13.0"

updateOptions := updateOptions.value.withGigahorse(false)

scalacOptions := Seq("-feature", "-deprecation", "-unchecked", "-Xlint")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.9"
  , "joda-time" % "joda-time" % "2.10.2"
  , "org.mindrot" % "jbcrypt" % "0.4"
  , "org.scalaj" %% "scalaj-http" % "2.4.2"
  , "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
  , "net.codingwell" %% "scala-guice" % "4.2.5"

  , "com.typesafe" % "config" % "1.3.4" % "compile"
  , "com.typesafe.akka" %% "akka-actor" % "2.5.23" % "compile"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2" % "compile"
  , "javax.inject" % "javax.inject" % "1" % "compile"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

parallelExecution in Test := false

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging
)
