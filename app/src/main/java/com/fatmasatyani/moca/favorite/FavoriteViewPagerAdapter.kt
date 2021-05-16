package com.fatmasatyani.moca.favorite

import android.content.Context
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.favorite.movie.FavoriteMovieFragment
import com.fatmasatyani.moca.favorite.tvshow.FavoriteTvShowFragment

class FavoriteViewPagerAdapter (private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    companion object {
        @StyleRes
        private val TAB_TITLES = intArrayOf(R.string.fav_movie, R.string.fav_tv_show)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment ()
            1 -> FavoriteTvShowFragment ()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(TAB_TITLES[position])

}