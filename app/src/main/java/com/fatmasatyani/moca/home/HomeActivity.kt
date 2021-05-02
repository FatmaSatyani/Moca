package com.fatmasatyani.moca.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}