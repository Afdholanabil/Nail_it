package com.example.nail_it

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nail_it.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bvBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_home->replaceFragment(HomeFragment())
                R.id.item_challange->replaceFragment(ChallangeFragment())
                R.id.item_interview->replaceFragment(InterviewFragment())
                R.id.item_work->replaceFragment(JobsFragment())
                R.id.item_profiles->replaceFragment(ProfileFragment())

                else->{

                }


        }

            true
        }

    }


    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction  = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_fragment, fragment)
        fragmentTransaction.commit()

    }
}