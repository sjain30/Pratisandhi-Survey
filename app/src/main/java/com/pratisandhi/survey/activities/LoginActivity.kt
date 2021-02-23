package com.pratisandhi.survey.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.pratisandhi.survey.R
import com.pratisandhi.survey.databinding.ActivityLoginBinding
import com.pratisandhi.survey.models.LoginViewModel
import com.pratisandhi.survey.utils.toast
import com.sample.viewbinding.activity.viewBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by viewBinding()
    private lateinit var viewModel: LoginViewModel
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val RC_SIGN_IN = 1
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        googleAuth()
        binding.googleSign.setOnClickListener {
            googleAuth()
        }

    }

    private fun googleAuth() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                viewModel.firebaseAuthWithGoogle(account).observe(this, { check ->
                    if (check) startActivity(Intent(this, MainActivity::class.java)); finish()
                })
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
                toast("Google sign in failed ${e.message}")
            }
        }
    }


    override fun onStart() {
        super.onStart()
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser != null) {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
            finish()
        }
    }
}