package com.asthiseta.bismillahtest.auth.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asthiseta.bismillahtest.R
import com.asthiseta.bismillahtest.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private var binding : ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val btnSignUp = binding!!.btnSSigned
        val etEmail = binding!!.etSEmailAddress
        val etConfPass = binding!!.etSConfPassword
        val etPass = binding!!.etSPassword
        val tvRedirectLogin = binding!!.tvRedirectLogin

        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}