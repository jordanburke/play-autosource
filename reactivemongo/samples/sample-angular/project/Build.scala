import sbt._
import Keys._
import play.Play.autoImport._
import PlayKeys._

object ApplicationBuild extends Build {

  val appName         = "sample-angular"
  val appVersion      = "2.1-SNAPSHOT"

  val ivyLocal = Seq(
    Resolver.file("local Ivy", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
  )

//  val mandubianRepo = Seq(
//    "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
//    "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/"
//  )

  val sonatypeRepo = Seq(
    "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    "Reactive Mongo" at "https://oss.sonatype.org/content/repositories/snapshots/org/reactivemongo/play2-reactivemongo_2.11/0.10.5.akka23-SNAPSHOT/",
    "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
  )
  val appDependencies = Seq()

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    version := appVersion,
    scalaVersion := "2.11.0",
    resolvers ++= sonatypeRepo ++ ivyLocal,
    libraryDependencies ++= Seq(
      "org.reactivemongo" %% "reactivemongo"       % "0.10.5.0.akka23",
      "play-autosource"   %% "reactivemongo"       % "2.1-SNAPSHOT",
      "junit"              % "junit"               % "4.8"         % "test"
    )
  )

}
