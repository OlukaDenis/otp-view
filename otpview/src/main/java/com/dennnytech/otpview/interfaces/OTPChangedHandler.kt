package com.dennnytech.otpview.interfaces

fun interface OTPChangedHandler {
    fun onChanged(otp: String)
}
