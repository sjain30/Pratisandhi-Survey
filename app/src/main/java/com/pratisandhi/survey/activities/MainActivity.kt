package com.pratisandhi.survey.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.pratisandhi.survey.R
import com.pratisandhi.survey.databinding.ActivityLoginBinding
import com.pratisandhi.survey.databinding.ActivityMainBinding
import com.sample.viewbinding.activity.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var mgoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnSurvey.setOnClickListener {
            startActivity(Intent(this, Survey::class.java))
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, History::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.signout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {

            // Write your code here to execute after dialog
            FirebaseAuth.getInstance().signOut()
            mgoogleSignInClient.signOut()
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        val gso: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mgoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }
}