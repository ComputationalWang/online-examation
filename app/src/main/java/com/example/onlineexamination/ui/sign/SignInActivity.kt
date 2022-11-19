package com.example.onlineexamination.ui.sign

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineexamination.R
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.databinding.ActivityLoginBinding
import com.example.onlineexamination.ui.dashboard.DashboardActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.material.snackbar.Snackbar


class SignInActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private var oneTapClient: SignInClient? = null
    private var signInRequest: BeginSignInRequest? = null
    private var signUpRequest: BeginSignInRequest? = null
    private val logOneTap = "One Tap Login"

    private val oneTapResult = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
        try {
            val credential = oneTapClient?.getSignInCredentialFromIntent(it.data)
            val idToken = credential?.googleIdToken
            credential?.displayName?.let { it1 -> SavedPreference.setDisplayName(this, it1) }
            credential?.givenName?.let { it1 -> SavedPreference.setGivenName(this, it1) }
            credential?.profilePictureUri?.let { it1 -> SavedPreference.setProfileUri(this, it1.toString()) }


            when {
                idToken != null -> {
                    val msg = "idToken: $idToken"
                    Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
                    Log.d(logOneTap, msg)
                    startActivity(Intent(this, DashboardActivity::class.java))
                }

                else -> {
                    val errorMsg = "No ID Token!"
                    Log.d(logOneTap, errorMsg)
                    Snackbar.make(binding.root, errorMsg, Snackbar.LENGTH_LONG).show()
                }
            }
        } catch (e: ApiException) {
            when (e.statusCode) {
                CommonStatusCodes.CANCELED -> {
                    Log.d(logOneTap, "One-tap dialog was closed")
                    Snackbar.make(binding.root, "One-tap dialog was closed.", Snackbar.LENGTH_LONG).show()
                }

                CommonStatusCodes.NETWORK_ERROR -> {
                    Log.d(logOneTap, "One-tap encountered a network error.")
                    Snackbar.make(
                        binding.root, "One-tap encountered a network error.",
                        Snackbar.LENGTH_INDEFINITE
                    ).show()
                }

                else -> {
                    Log.d(logOneTap, "Could not get credential info from result. Error: ${e.localizedMessage}")
                    Snackbar.make(
                        binding.root, "Could not get credential info from result. " +
                                "Error: ${e.localizedMessage}", Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.default_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            // Automatically sign in when exactly one credential is retrieved.
            .setAutoSelectEnabled(true)
            .build()

        signUpRequest = BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.default_web_client_id))
                    // Show all accounts on the device.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .build()

        binding.btnSignIn?.setOnClickListener {
            displaySign(true)
        }
    }

    private fun displaySign(signIn: Boolean) {
        val request: BeginSignInRequest? = if(signIn) {
            signInRequest
        } else {
            signUpRequest
        }

        oneTapClient?.beginSignIn(request!!)?.addOnSuccessListener(this) { result ->
            try {
                val ib = IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                oneTapResult.launch(ib)
            } catch (e: IntentSender.SendIntentException) {
                Log.e("Login Button Click", "Could not start One Tap UI: ${e.localizedMessage}")

            }
        }
            ?.addOnFailureListener(this) { e ->
                //No Google Accounts found.
                displaySign(false)
                Log.d("Login Button Click", e.localizedMessage!!)
            }
    }
}
