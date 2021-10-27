package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
    }

    fun openRegistration(view: View) {
        val registration = Intent(this, Registration::class.java)
        startActivity(registration)
    }

    fun openLogin(view: View) {
        val login = Intent(this, Login::class.java)
        startActivity(login)
    }


}
