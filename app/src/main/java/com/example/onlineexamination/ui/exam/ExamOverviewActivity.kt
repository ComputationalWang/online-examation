package com.example.onlineexamination.ui.exam

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.data.model.database.exam.ExamViewModel
import com.example.onlineexamination.data.model.database.exam.ExamViewModelFactory
import com.example.onlineexamination.data.model.database.response.ExamResponse
import com.example.onlineexamination.data.model.database.response.FirebaseCallback
import com.example.onlineexamination.databinding.ActivityExamOverviewBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import java.util.*


class ExamOverviewActivity : AppCompatActivity() {


//    private var displayName : String? = ""
//    private var personPhoto: Uri? = null

    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private var exams = mutableListOf<Exam>()

    private lateinit var viewModel: ExamViewModel

//    lateinit var toggle : ActionBarDrawerToggle

    private var _binding: ActivityExamOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityExamOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val listView = binding.listview

//        val exam = (SavedPreference.getId(this)
//            ?.let { SavedPreference.getGivenName(this)?.let { it1 -> Exam("Kek", it1, it, Date(), Date(), null) } })


//        val drawerLayout : DrawerLayout = binding.ExamOverviewDrawerLayout
//        val navView : NavigationView = binding.navView
//        val circleImageView : CircleImageView = binding.navView.getHeaderView(0).findViewById(R.id.circleImageView)
//        val usernameView : TextView = binding.navView.getHeaderView(0).findViewById(R.id.username)

//        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

//        val colRef1 = db.collection("exams")
//        if (exam != null) {
//            colRef1.add(exam)
//        }

        val viewModelFactory = ExamViewModelFactory(SavedPreference.getId(this)!!)
        viewModel = ViewModelProvider(this, viewModelFactory)[ExamViewModel::class.java]
        getResponseUsingCoroutines()

        listView.setOnItemClickListener { parent, view, position, id ->

            val exam = exams[position]
            val i = Intent(this, ExamEditActivity::class.java)
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

    private fun getResponseUsingCoroutines() {
        viewModel.responseLiveData.observe(this) {
            if(it.exams != null) {
                print(it)
                exams.addAll(it.exams!!)

                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, exams)
                binding.listview.adapter = arrayAdapter
            } else {
                Log.e(TAG, it.exception?.message.orEmpty())
            }
        }
    }
}