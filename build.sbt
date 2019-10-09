lazy val otpService = project.in(file("otpService"))
  .settings(
    name := "otpService",
    version := "0.0.1-SNAPSHOT",
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-core" % "0.18.21",
      "org.http4s" %% "http4s-blaze-server" % "0.18.21",
      "org.http4s" %% "http4s-dsl" % "0.18.21",
      "org.http4s" %% "rho-swagger" % "0.18.0",
      "org.scalatest" %% "scalatest" % "3.0.5" % Test
    )
  ).dependsOn(otpUtility)


lazy val otpUtility = project.in(file("otpUtility"))
  .settings(
    libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
    "commons-codec" % "commons-codec" % "1.10"
    )
  )
