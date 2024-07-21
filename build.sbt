ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .settings(
    name := "MessageApp"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.8.5",
  "com.typesafe.akka" %% "akka-http" % "10.5.3",
  "com.typesafe.akka" %% "akka-stream" % "2.8.6",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.3",
  "com.typesafe.akka"  %% "akka-actor-typed" %  "2.8.6"
)

resolvers += "akka-http" at "https://repo.akka.io/releases"