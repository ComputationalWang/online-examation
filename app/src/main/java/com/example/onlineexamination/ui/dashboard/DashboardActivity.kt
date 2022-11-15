package com.example.onlineexamination.ui.dashboard

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineexamination.R
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.databinding.ActivityDashboardBinding
import com.example.onlineexamination.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class DashboardActivity : AppCompatActivity() {

    private var _binding: ActivityDashboardBinding? = null
    private val binding get() = _binding!!

    private var personName : String? = ""
    private var personGivenName : String? = ""
    private var personFamilyName : String? = ""
    private var personEmail : String? = ""
    private var personId : String? = ""
    private var personPhoto: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

            personName = SavedPreference.getEmail(this)
            personGivenName = SavedPreference.getGivenName(this)


        binding.textView.text = getString(R.string.welcome, personGivenName!!)
    }
}
