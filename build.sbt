name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies ++= Seq(
  guice,
  "com.digitaltangible" %% "play-guard" % "2.2.0",
  "com.h2database" % "h2" % "1.4.196",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "org.postgresql" % "postgresql" % "42.2.2",
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)


// No need to run tests while building jar
test in assembly := {}
// Simple and constant jar name
assemblyJarName in assembly := s"app-assembly.jar"
//  Merge strategy for assembling conflicts
assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}