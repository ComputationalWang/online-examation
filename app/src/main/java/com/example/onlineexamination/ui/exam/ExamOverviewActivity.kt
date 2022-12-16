package com.example.onlineexamination.ui.exam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.onlineexamination.R
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.databinding.ActivityExamOverviewBinding
import com.example.onlineexamination.ui.dashboard.DashboardActivity
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ExamOverviewActivity : AppCompatActivity() {


//    private var displayName : String? = ""
//    private var personPhoto: Uri? = null

    private var exams = mutableListOf<Exam>()

//    lateinit var toggle : ActionBarDrawerToggle

    private var _binding: ActivityExamOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExamOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.listview

        exams.add(Exam("Test", Date(), Date(), null))


//        val drawerLayout : DrawerLayout = binding.ExamOverviewDrawerLayout
//        val navView : NavigationView = binding.navView
//        val circleImageView : CircleImageView = binding.navView.getHeaderView(0).findViewById(R.id.circleImageView)
//        val usernameView : TextView = binding.navView.getHeaderView(0).findViewById(R.id.username)

//        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, exams)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val exam = exams[position]
            val i = Intent(this, ExamEditActivity::class.java)
            i.putExtra("title", exam.title)
            i.putExtra("createdAt", exam.createdAt)
            i.putExtra("id", exam.id)
            startActivity(i)
        }

//        displayName = SavedPreference.getDisplayName(this)
//        personPhoto = Uri.parse(SavedPreference.getProfileUri(this))

//        Picasso.Builder(this).build().load(personPhoto).into(circleImageView)
//        usernameView.text = displayName
//
//        navView.setNavigationItemSelectedListener {
//
//            when(it.itemId) {
//                R.id.nav_home -> startActivity(Intent(this, DashboardActivity::class.java))
//                R.id.nav_overview -> drawerLayout.closeDrawers()
//                R.id.nav_manage -> Toast.makeText(applicationContext, "Clicked Manage", Toast.LENGTH_SHORT).show()
//                R.id.nav_info -> Toast.makeText(applicationContext, "Clicked Info", Toast.LENGTH_SHORT).show()
//                R.id.nav_logout -> Toast.makeText(applicationContext, "Clicked Logout", Toast.LENGTH_SHORT).show()
//                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
//                R.id.nav_rate -> Toast.makeText(applicationContext, "Clicked Rate", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }
    }
}