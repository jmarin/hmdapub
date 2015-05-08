val projectName = "hmdapub"

val hmdapub = crossProject
  .settings(
    scalaVersion := "2.11.6",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "utest" % "0.3.0",
      "com.lihaoyi" %%% "upickle" % "0.2.8"),
    testFrameworks += new TestFramework("utest.runner.Framework")
  ).jsSettings(
    // JS-specific settings here
    name := projectName + "-js",
    scalaJSStage in Global := FastOptStage,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.8.0"  
    )
  ).jvmSettings(
    // JVM-specific settings here
    name := projectName + "-jvm"
  )

lazy val js = hmdapub.js

lazy val jvm = hmdapub.jvm
