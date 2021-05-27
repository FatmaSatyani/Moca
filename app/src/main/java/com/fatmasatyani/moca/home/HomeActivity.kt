package com.fatmasatyani.moca.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fatmasatyani.moca.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.homeViewpager.adapter = sectionPagerAdapter
        activityHomeBinding.homeTab.setupWithViewPager(activityHomeBinding.homeViewpager)

        supportActionBar?.elevation = 0f

        activityHomeBinding.fbFavorite.setOnClickListener {
//            try {
//                moveToFavoriteFragment()
//            } catch (e: Exception) {
//                Toast.makeText(this, "Module not found", Toast.LENGTH_SHORT).show()
//            }
        }
    }

//    private fun moveToFavoriteFargment() {
//        startActivity(Intent(this, Class.forName("com.fatmasatyani.favorite")))
//    }

    private fun moveToFavoriteFragment() {
        val fragment = instantiateFragment()
        Log.d("fragmentName", fragment.toString())
    }

    private fun instantiateFragment(): Fragment? {
        return try {
            Class.forName("com.fatmasatyani.favorite").newInstance() as Fragment
        } catch (e: Exception) {
            null
        }
    }
}