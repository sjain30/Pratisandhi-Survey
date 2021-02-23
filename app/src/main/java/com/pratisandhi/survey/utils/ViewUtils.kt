package com.pratisandhi.survey.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun snackbar(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}