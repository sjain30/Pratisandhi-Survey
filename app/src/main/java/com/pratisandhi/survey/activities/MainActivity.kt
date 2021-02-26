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
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        prettyNameMapping["ques2"] = "Email Address"
        prettyNameMapping["ques3"] = "Contact Number"
        prettyNameMapping["ques4"] = "Age"
        prettyNameMapping["ques5"] = "City"
        prettyNameMapping["ques6"] = "Sex"
        prettyNameMapping["ques7"] = "Gender"
        prettyNameMapping["ques8"] = "Do you belong to a Rural or an Urban setting?"
        prettyNameMapping["ques9"] = "Marital/Relationship Status"
        prettyNameMapping["ques10"] =
            "At what age did you first engage in any form of sexual activity?"
        prettyNameMapping["ques11"] = "At what age did you first engage in sexual intercourse?"
        prettyNameMapping["ques12"] = "How often do you engage in sexual activity? "
        prettyNameMapping["ques13"] = "How often do you engage in sexual intercourse? "
        prettyNameMapping["ques14"] =
            "What are your primary sources of information on sexual health?"
        prettyNameMapping["ques15"] =
            "Have you ever consulted a doctor for any sexual health concerns? "
        prettyNameMapping["ques16"] =
            "If you answered yes to the previous question, were you able to get an adequate solution to your concern?"
        prettyNameMapping["ques17"] =
            "Which of the following sexual activities have you engaged in during the past two years?"
        prettyNameMapping["ques18"] = "Did COVID impact your sexual life?"
        prettyNameMapping["ques19"] = "How often do you use contraceptives?"
        prettyNameMapping["ques20"] = "Which of the following contraceptives are you familiar with?"
        prettyNameMapping["ques21"] = "Which of the following contraceptives do you use regularly?"
        prettyNameMapping["ques22"] =
            "Do you think that the current awareness levels on contraception are adequate? "
        prettyNameMapping["ques23"] =
            "Have you ever experienced any negative side effects from contraceptive usage?"
        prettyNameMapping["ques24"] = "If yes, what side effects have you faced?"
        prettyNameMapping["ques25"] = "Are you, or will you be comfortable buying contraceptives?"
        prettyNameMapping["ques26"] =
            "Which of the following emotions do you identify with when trying to purchase contraceptives?"
        prettyNameMapping["ques27"] =
            "Are contraceptives easily available near your area of residence?"
        prettyNameMapping["ques28"] =
            "What are some challenges you face when trying to access contraceptives? (Please write N/A if no challenges were faced)"
        prettyNameMapping["ques29"] =
            "Where will be the most comfortable place for you to buy contraceptives?"
        prettyNameMapping["ques30"] =
            "Who mostly buys the contraceptive that you or your partner uses?"
        prettyNameMapping["ques31"] =
            "Have you ever felt pressured by peers or your partner to not use contraception?"
        prettyNameMapping["ques32"] = "For what purpose do you usually use condoms?"
        prettyNameMapping["ques33"] = "How effective are condoms in preventing pregnancy?"
        prettyNameMapping["ques34"] = "What condom brand do you think is most reliable?"
        prettyNameMapping["ques35"] = "Have you ever used an oral emergency pill?"
        prettyNameMapping["ques36"] = "For what reason have you used an emergency pill?"
        prettyNameMapping["ques37"] =
            "How many times would you say you have used an emergency pill in the past three years?"
        prettyNameMapping["ques38"] =
            "Are there any barriers you have faced in using emergency pills? If yes, what are they?"
        prettyNameMapping["ques39"] =
            "Have you heard about sexually transmitted infections such as HIV/AIDS, Chlamydia, Herpes, etc?"
        prettyNameMapping["ques40"] = "Have you ever had a STI scare?"
        prettyNameMapping["ques41"] =
            "What are the sources you rely on for information related to STIs?"
        prettyNameMapping["ques42"] = "Have you ever gotten tested for STIs?"
        prettyNameMapping["ques43"] =
            "Have you ever faced any barriers when getting tested for STIs? If yes, what are they?"
        prettyNameMapping["ques44"] = "Do you think getting tested for STIs is important?"
        prettyNameMapping["ques45"] =
            "Do you think it is important to get tested even if you have one sexual partner?"
        prettyNameMapping["ques46"] = "Has your partner ever gotten tested for STIs?"
        prettyNameMapping["ques47"] =
            "Have you ever had a conversation with your partner about their STI status before engaging in sexual activity?"
        prettyNameMapping["ques48"] =
            "If you have multiple sexual partners, do you think it is your responsibility to get tested?"
        prettyNameMapping["ques49"] = "Do you think it is only your responsibility to get tested?"
        prettyNameMapping["ques50"] =
            "If you have only one sexual partner, who would you prefer gets tested?"
        prettyNameMapping["ques51"] =
            "When you think of getting tested, what are the emotions you feel?"
        prettyNameMapping["ques52"] =
            "Have you ever consulted a doctor or a medial professional to get an opinion related to STIs?"
        prettyNameMapping["ques53"] =
            "What do you think is the best place for you to get tested, if you had to?"
        prettyNameMapping["ques54"] =
            "Condoms are the only contraceptive which protects from STIs arising from sexual intercourse."

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
            mGoogleSignInClient.signOut()
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}