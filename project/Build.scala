import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName = "vidal-stat"
    val appVersion = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "org.mongodb" %% "casbah" % "2.5.1",
        "org.scalatest" %% "scalatest" % "1.9.1" % "test",
        "com.github.simplyscala" %% "scalatest-embedmongo" % "0.2.1" % "test"
    )


    val main = play.Project(appName, appVersion, appDependencies).settings(
        // Add your own project settings here
    )

}