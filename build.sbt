organization := "in.norbor"

name := "yoda-common"

version := "1.0.1"

scalaVersion := "2.13.5"

updateOptions := updateOptions.value.withGigahorse(false)

scalacOptions := Seq("-feature", "-deprecation", "-unchecked", "-Xlint")
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.12.2" % Compile
  , "com.typesafe" % "config" % "1.4.1" % Compile
  , "joda-time" % "joda-time" % "2.10.10" % Compile
  , "org.mindrot" % "jbcrypt" % "0.4" % Compile
  , "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.6" % "test"
)

parallelExecution in Test := false

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging
)
