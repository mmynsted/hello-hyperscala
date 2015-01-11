import sbt._
import Keys._

object HelloHyperscalaBuild extends Build {
import Dependencies._

  val scalacFlags =  Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  )

  lazy val project = Project (
    id = "hello",
    base = file("."),
    settings = Defaults.defaultSettings ++
    Seq(
      version      := "1.0.0",
      organization := "com.growingliberty",
      scalaVersion := "2.11.4",
      scalacOptions ++= scalacFlags,
      resolvers ++= Seq("Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
                        "twitter-repo" at "http://maven.twttr.com",
                         "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"),
      libraryDependencies ++= Seq(
        powerScalaReflect,
        powerScalaHierarchy,
        powerScalaProperty,
        powerScalaJson,
        outrNetCore, 
        outrNetServlet,
        outrNetJetty,
        hyperscala,
        scalaSwing,
        commonsCodec,
        jdom,
        jaxen,
        htmlcleaner,
        akkaActors,
        uaDetector,
        githubCore,
        argonaut,
        musterJawn,
        musterJackson,
        scalaTest,
        scalaCheck
      )
    )
  )
}
