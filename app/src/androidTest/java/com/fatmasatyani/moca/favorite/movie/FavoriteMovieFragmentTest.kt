package com.fatmasatyani.moca.favorite.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.SingleFragmentActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteMovieFragmentTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private var fragment = FavoriteMovieFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(fragment)
    }

    @Test
    fun loadFavoriteMovies() {
        onView(ViewMatchers.withText("FAV MOVIE")).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<FavoriteMovieViewHolder>(0,click()))
        onView(withId(R.id.fav_title)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_image)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_rating)).check(matches(isDisplayed()))
    }

    class FavoriteMovieViewHolder (view: View) : RecyclerView.ViewHolder(view)
}