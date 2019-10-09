package com.services

import cats.effect._
import fs2.StreamApp
import org.http4s.rho.swagger.syntax.io._
import org.http4s.server.blaze.BlazeBuilder

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class OtpServer extends StreamApp[IO] {
  val builder: BlazeBuilder[IO] =
    BlazeBuilder[IO]
        .bindHttp(8080, "0.0.0.0")
        .withIdleTimeout(300.seconds)

  val otpService = OtpService.service.toService(createRhoMiddleware())

  def stream(args: List[String], requestShutdown: IO[Unit]): fs2.Stream[IO, StreamApp.ExitCode] = {
    builder
      .mountService(otpService, "/otp")
      .serve
  }
}

object OtpServerMain extends OtpServer