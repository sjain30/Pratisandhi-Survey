package com.pratisandhi.survey.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.pratisandhi.survey.utils.SharedPreference

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val check = MutableLiveData<Boolean>()

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun firebaseAuthWithGoogle(account: GoogleSignInAccount?): LiveData<Boolean>{
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    user?.email?.let { SharedPreference.setEmail(getApplication(), it) }
                    user?.displayName?.let { SharedPreference.setUsername(getApplication(), it) }
                    check.value = true
                }else check.value = false
            }
            .addOnFailureListener {
                check.value = false
            }
        return check
    }

}