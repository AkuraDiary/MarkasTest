package com.asthiseta.bismillahtest.auth.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asthiseta.bismillahtest.R
import com.asthiseta.bismillahtest.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private var binding : ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}