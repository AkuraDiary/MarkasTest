package com.asthiseta.bismillahtest.auth.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asthiseta.bismillahtest.auth.signup.SignUpActivity
import com.asthiseta.bismillahtest.databinding.ActivityLoginBinding
import com.asthiseta.bismillahtest.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private var tvRedirectSignUp: TextView? = null
    private var edtEmail: EditText? = null
    private var edtPass: EditText? = null
    private var btnLogin: Button? = null

    private lateinit var auth: FirebaseAuth
    private var loginBinding: ActivityLoginBinding? = null

    private var signUpIntent: Intent? = null
    private var homeIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding!!.root)

        signUpIntent = Intent(this@LoginActivity, SignUpActivity::class.java)
        homeIntent = Intent(this@LoginActivity, MainActivity::class.java)

        tvRedirectSignUp = loginBinding!!.tvRedirectSignUp
        edtEmail = loginBinding!!.etEmailAddress
        edtPass = loginBinding!!.etPassword
        btnLogin = loginBinding!!.btnLogin

        //auth object
        auth = FirebaseAuth.getInstance()


        btnLogin?.setOnClickListener {
            login()
        }

        tvRedirectSignUp?.setOnClickListener {
            startActivity(signUpIntent)
            // using finish() to end the activity
            finish()
        }
    }

    private fun login() {
        val email = edtEmail?.text.toString().trim()
        val pass = edtPass?.text.toString().trim()

        // check pass
        when {
            email.isBlank() -> {
                edtEmail?.error = "Email can't be blank"
                return
            }
            pass.isBlank() -> {
                edtPass?.error = "Password can't be blank"
                return
            }
        }

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                startActivity(homeIntent)
                finish()
            } else {
                Log.d("LOGIN : ", it.result.toString())
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        loginBinding = null
        super.onDestroy()
    }
}