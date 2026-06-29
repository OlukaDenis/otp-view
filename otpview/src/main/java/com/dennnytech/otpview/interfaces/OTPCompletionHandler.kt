package com.dennnytech.otpview.interfaces

fun interface OTPCompletionHandler {
    fun onComplete(otp: String)
}