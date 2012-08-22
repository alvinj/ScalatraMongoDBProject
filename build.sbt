organization := "com.example"

name := "scalatra-sbt-prototype"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.1.0",
  "org.scalatra" % "scalatra-scalate" % "2.1.0",
  "org.scalatra" % "scalatra-specs2" % "2.1.0" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
  "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
  "org.slf4j" % "slf4j-api" % "1.6.6",
  "org.slf4j" % "slf4j-simple" % "1.6.6",
  "org.clapper" %% "grizzled-slf4j" % "0.6.9",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.5.v20120716" % "container",
  "org.eclipse.jetty" % "test-jetty-servlet" % "8.1.5.v20120716" % "test",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

