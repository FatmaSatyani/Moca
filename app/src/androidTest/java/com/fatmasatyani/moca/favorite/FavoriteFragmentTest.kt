package com.fatmasatyani.moca.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.SingleFragmentActivity
import com.fatmasatyani.moca.home.HomeActivity
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import com.fatmasatyani.moca.utils.FakeData
import junit.framework.TestCase
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteFragmentTest {

    private val dummyFavoriteMovie = FakeData.getFavoriteDummyMovie()
    private val dummyFavoriteTvShow = FakeData.getFavoriteDummyTvShow()

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private var fragment = FavoriteFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(fragment)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavoriteMovie.size))
    }

    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(allOf(withId(R.id.rv_tvShows))).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavoriteTvShow.size))
    }

}