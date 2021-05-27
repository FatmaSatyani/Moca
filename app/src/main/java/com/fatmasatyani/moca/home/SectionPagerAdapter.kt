package com.fatmasatyani.moca.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
//import com.fatmasatyani.favorite.FavoriteFragment
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.movie.MovieFragment
import com.fatmasatyani.moca.tvshow.TvShowFragment

class SectionPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StyleRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshow, R.string.favorite)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment ()
            1 -> TvShowFragment ()
            2 -> {moveToFavoriteFragment(); Fragment()}
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

//    private fun moveToFavoriteFragment() {
//        mContext.startActivity(Intent(mContext, Class.forName("com.fatmasatyani.favorite")))
//    }
    private fun moveToFavoriteFragment() {
        val fragment = instantiateFragment()
        Log.d("fragmentName", fragment.toString())
        }
    }

    private fun instantiateFragment(): Fragment? {
        return try {
            Class.forName("com.fatmasatyani.favorite").newInstance() as Fragment
        } catch (e: Exception) {
            null
        }

    }

