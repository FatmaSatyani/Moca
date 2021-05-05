package com.fatmasatyani.moca.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.fatmasatyani.moca.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DummyData.generateMovie()
    private val dummyTvShow = DummyData.generateTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

//    Movie Testing
    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

//    @Test
//    fun loadMovieDetail() {
//
//        delay (5)
//
//        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder> (0,click()))
//        onView(withId(R.id.detail_toolbar_layout)).check(matches(isDisplayed()))
//        onView(withId(R.id.detail_toolbar_layout)).check(matches(withContentDescription(dummyMovie[0].movieTitle)))
//        onView(withId(R.id.detail_background)).check(matches(isDisplayed()))
//        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))
//        onView(withId(R.id.btn_play)).perform(click())
//        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        device.pressBack()
//        onView(withText("DESCRIPTION")).perform(click())
//        onView(withText("ABOUT")).perform(click())
//        onView(withId(R.id.rv_about)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.tv_desc)).check(matches(withText(dummyMovie[0].movieDescription)))
//
//    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }
//    @Test
//    fun loadTvShowDetail() {
//
//        delay (5)
//
//        onView(withText("TV SHOW")).perform(ViewActions.click())
//        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder> (0,click()))
//        onView(withId(R.id.detail_toolbar_layout)).check(matches(isDisplayed()))
//        onView(withId(R.id.detail_toolbar_layout)).check(matches(withContentDescription(dummyTvShow[0].tvShowTitle)))
//        onView(withId(R.id.detail_background)).check(matches(isDisplayed()))
//        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))
//        onView(withId(R.id.btn_play)).perform(click())
//        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        device.pressBack()
//        onView(withText("DESCRIPTION")).perform(click())
//        onView(withText("ABOUT")).perform(click())
//        onView(withId(R.id.rv_about)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.tv_desc)).check(matches(withText(dummyTvShow[0].tvShowDescription)))
//    }

    private fun delay (second: Long = 1) {
        Thread.sleep(1000*second)
    }
}