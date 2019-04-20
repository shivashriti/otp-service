package com.services

import cats.effect.IO
import org.http4s.rho.RhoService

import scala.util.{Success, Try}

object OtpService {

  val service = new RhoService[IO] {

    import org.http4s.rho.swagger.syntax.io._

    "generates an 8 digit otp which will be valid for 30 seconds" **
      GET / "generate" |>> {
        Ok(Util.totpSHA1.generate())
    }

    "validates otp" **
      GET / "validate" / pathVar[String]("otp", "otp to validate") |>> { otp: String =>
      Try(Util.totpSHA1.validate(otp)) match {
        case Success(true) => Ok("SUCCESS!!! OTP is valid")
        case Success(false) => Ok("ERROR!!! OTP is invalid")
        case _ => PreconditionFailed("Invalid format. Please enter a valid otp")
      }
    }

  }
}
