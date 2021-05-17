package com.fatmasatyani.moca.tvshow

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.home.HomeActivity
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import com.fatmasatyani.moca.utils.FakeData
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowFragmentTest {

    private val dummyTvShow = FakeData.generateDummyTvShow()

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadTvShow() {
        onView(ViewMatchers.withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadTvShowDetail() {
        onView(ViewMatchers.withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId(R.id.tv_tvShow_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShow_release)).check(matches(isDisplayed()))
        onView(withId(R.id.scrollView)).perform(swipeUp())
        onView(withId(R.id.tv_tvShow_textOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShow_RatingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.backdrop_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_tv_favorite)).perform(click())
    }
}