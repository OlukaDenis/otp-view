package com.dennytech.otpview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dennnytech.otpview.interfaces.OTPCompletionHandler
import com.dennytech.otpview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.otpView.setOnCompleteListener { otp ->
            Toast.makeText(
                this@MainActivity,
                "OTP Entered: $otp",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
