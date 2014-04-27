name := "subcut"

organization := "com.escalatesoft.subcut"

version := "2.1"

crossScalaVersions := Seq("2.11.0", "2.10.4")

scalaVersion := "2.11.0"

scalacOptions += "-deprecation"

libraryDependencies += "junit" % "junit" % "4.5" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.4" % "test"

libraryDependencies <<= (scalaVersion, libraryDependencies) { (ver, deps) =>
  deps :+ "org.scala-lang" % "scala-compiler" % ver 
}

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://github.com/dickwall/subcut</url>
  <licenses>
    <license>
      <name>Apache 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:dickwall/subcut.git</url>
    <connection>scm:git:git@github.com:dickwall/subcut.git</connection>
  </scm>
  <developers>
    <developer>
      <id>dickwall</id>
      <name>Dick Wall</name>
      <url>http://about.me/dickwall</url>
    </developer>
  </developers>)
