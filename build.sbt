name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += Resolver.jcenterRepo

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

swaggerDomainNameSpaces := Seq("models")

libraryDependencies ++= Seq(
  guice,
  "com.digitaltangible" %% "play-guard" % "2.2.0",
  "com.h2database" % "h2" % "1.4.196",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "org.postgresql" % "postgresql" % "42.2.2",
  "com.iheart" %% "play-swagger" % "0.7.4",
  "org.webjars" % "swagger-ui" % "3.14.0",
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)

assemblyMergeStrategy in assembly := {
  case manifest if manifest.contains("MANIFEST.MF") =>
    // We don't need manifest files since sbt-assembly will create
    // one with the given settings
    MergeStrategy.discard
  case referenceOverrides if referenceOverrides.contains("reference-overrides.conf") =>
    // Keep the content for all reference-overrides.conf files
    MergeStrategy.concat
  case x =>
    // For all the other files, use the default sbt-assembly merge strategy
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

lazy val root = (project in file(".")).enablePlugins(PlayScala, SwaggerPlugin)