package com.example.onlineexamination.ui.dashboard

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.drawerlayout.widget.DrawerLayout
import com.example.onlineexamination.R
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.databinding.ActivityDashboardBinding
import com.example.onlineexamination.databinding.ActivityLoginBinding
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView

class DashboardActivity : AppCompatActivity() {


    private var displayName : String? = ""
    private var personGivenName : String? = ""
    private var personFamilyName : String? = ""
    private var personEmail : String? = ""
    private var personId : String? = ""
    private var personPhoto: Uri? = null

    lateinit var toggle : ActionBarDrawerToggle

    private var _binding: ActivityDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val drawerLayout : DrawerLayout = binding.dashboardDrawerLayout
        val navView : NavigationView = binding.navView
//        val circleImageView : CircleImageView = binding.navView.
        val textView : TextView = binding.textView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayName = SavedPreference.getDisplayName(this)
        personGivenName = SavedPreference.getGivenName(this)
        personPhoto = Uri.parse(SavedPreference.getProfileUri(this))


        textView.text = getString(R.string.welcome, personGivenName!!)
//        circleImageView.setImageURI(personPhoto)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_overview -> Toast.makeText(applicationContext, "Clicked Overview", Toast.LENGTH_SHORT).show()
                R.id.nav_manage -> Toast.makeText(applicationContext, "Clicked Manage", Toast.LENGTH_SHORT).show()
                R.id.nav_info -> Toast.makeText(applicationContext, "Clicked Info", Toast.LENGTH_SHORT).show()
                R.id.nav_logout -> Toast.makeText(applicationContext, "Clicked Logout", Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
                R.id.nav_rate -> Toast.makeText(applicationContext, "Clicked Rate", Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
