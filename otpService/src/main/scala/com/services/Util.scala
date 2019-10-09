package com.services

import ejisan.kuro.otp.{OTPAlgorithm, OTPKey, TOTP}

object Util {
  private val hex = "3132333435363738393031323334353637383930"
  private val otpkeySHA1 = OTPKey.fromHex(hex)
  val totpSHA1 = TOTP(OTPAlgorithm.SHA1, 8, 30, otpkeySHA1)
}
