package com.example.onlineexamination.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineexamination.R
import com.example.onlineexamination.ui.dashboard.DashboardActivity
import com.example.onlineexamination.ui.sign.SignInActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        /**
         * Checks if user is authenticated.
         * If authenticated -> goes to DashboardActivity
         * else -> goes to SignInActivity
         */
        Handler().postDelayed({
            if(user != null){
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                startActivity(Intent(this, SignInActivity::class.java))
            }

        }, 2000)
    }
}