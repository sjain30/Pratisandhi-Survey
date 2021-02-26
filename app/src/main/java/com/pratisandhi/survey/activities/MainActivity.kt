package com.pratisandhi.survey.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.ajts.androidmads.library.SQLiteToExcel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.pratisandhi.survey.R
import com.pratisandhi.survey.databinding.ActivityMainBinding
import com.sample.viewbinding.activity.viewBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var mgoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PackageManager.PERMISSION_GRANTED
        )

        binding.btnSurvey.setOnClickListener {
            startActivity(Intent(this, Survey::class.java))
        }

        binding.btnHistory.setOnClickListener {
            exportData()
        }
    }

    private fun exportData() {
        val sqliteToExcel = SQLiteToExcel(this, "SurveyDatabase", "/storage/emulated/0/Download/")
        val prettyNameMapping = HashMap<String, String>()
        prettyNameMapping["ques1"] = "Name"
        prettyNameMapping["ques8"] = "Do you belong to a Rural or an Urban setting?"
        sqliteToExcel.setPrettyNameMapping(prettyNameMapping)
        sqliteToExcel.exportSingleTable(
            "SurveyEntity",
            "survey.xls",
            object : SQLiteToExcel.ExportListener {
                override fun onStart() {
                    Toast.makeText(this@MainActivity, "Processing!", Toast.LENGTH_SHORT).show()
                }

                override fun onCompleted(filePath: String?) {
                    Toast.makeText(this@MainActivity, "File downloaded!", Toast.LENGTH_SHORT).show()
//                    val uri = FileProvider.getUriForFile(
//                        this@MainActivity,
//                        this@MainActivity.packageName + ".provider",
//                        File(filePath)
//                    )
//                    val intent = Intent(Intent.ACTION_SEND)
//                    intent.setDataAndType(uri, "application/vnd.ms-excel")
//                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//                    intent.putExtra(Intent.EXTRA_STREAM, uri)
//                    Log.i("TAG", "onCompleted: \${uri.toString()}")
//                    this@MainActivity.startActivity(Intent.createChooser(intent, "Select"))
                }

                override fun onError(e: Exception?) {
                    Toast.makeText(this@MainActivity, "An error occurred!", Toast.LENGTH_SHORT)
                        .show()
                    Log.e("TAG", "onError: ${e.toString()}")
                }
            })
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