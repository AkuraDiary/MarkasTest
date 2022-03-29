package com.asthiseta.bismillahtest.auth.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.asthiseta.bismillahtest.R
import com.asthiseta.bismillahtest.auth.login.LoginActivity
import com.asthiseta.bismillahtest.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private var binding : ActivitySignUpBinding? = null


    private var btnSignUp : Button? = null
    private var etEmail : EditText? = null
    private var etConfPass : EditText? = null
    private var etPass : EditText? = null //binding!!.etSPassword
    private var tvRedirectLogin : TextView? = null // binding!!.tvRedirectLogin
    private var loginIntent : Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        loginIntent = Intent(this@SignUpActivity, LoginActivity::class.java)

        btnSignUp = binding!!.btnSSigned
        etEmail = binding!!.etSEmailAddress
        etConfPass = binding!!.etSConfPassword
        etPass = binding!!.etSPassword
        tvRedirectLogin = binding!!.tvRedirectLogin

        auth = Firebase.auth

        btnSignUp!!.setOnClickListener {
            signUpUser()
        }

        // switching from signUp Activity to Login Activity
        tvRedirectLogin!!.setOnClickListener {
            startActivity(loginIntent)
        }
    }

    private fun signUpUser() {
        val email = etEmail?.text.toString()
        val pass = etPass?.text.toString()
        val confirmPassword = etConfPass?.text.toString()

        // check pass
        when{
            email.isBlank()->{
                error("Email can't be blank")
            }
            pass.isBlank()->{
                error("Password can't be blank")
            }
            confirmPassword.isBlank()->{
                error("This field can't be blank")
            }
        }

        if (pass != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up, Please Login", Toast.LENGTH_SHORT).show()
                // move into login activity
                startActivity(loginIntent)
                finish()
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        binding = null

        super.onDestroy()
    }
}