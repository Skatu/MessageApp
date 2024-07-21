ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
  .settings(
    name := "MessageApp"
  )

//resolvers += "Confluent" at "https://packages.confluent.io/maven/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.8.5",
  "com.typesafe.akka" %% "akka-http" % "10.5.3",
  "com.typesafe.akka" %% "akka-stream" % "2.8.6",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.3",
  "com.typesafe.akka"  %% "akka-actor-typed" %  "2.8.6",

  "com.fasterxml.jackson.core" % "jackson-databind" % "2.17.0",
  "com.sksamuel.avro4s" %% "avro4s-core" % "5.0.13",
  "io.confluent" % "kafka-avro-serializer" % "7.6.1",
  "org.apache.kafka" % "kafka-clients" % "7.6.1-ce",
)

//resolvers += "akka-http" at "https://repo.akka.io/releases"

resolvers ++=Seq(
  "akka-http" at "https://repo.akka.io/releases",
  "Confluent" at "https://packages.confluent.io/maven/"
)