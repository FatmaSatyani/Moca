package com.fatmasatyani.moca.home

import android.content.Context
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.favorite.FavoriteFragment
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
            2 -> FavoriteFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])
}