name := """sistepd"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "net.sf.brunneng.fusie" % "fusie" % "0.8.1"

libraryDependencies += "org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.2"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"



fork in run := true