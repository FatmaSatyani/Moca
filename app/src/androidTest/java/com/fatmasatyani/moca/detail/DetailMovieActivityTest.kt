package com.fatmasatyani.moca.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import com.fatmasatyani.moca.utils.FakeData
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailMovieActivityTest {

    var dummyMovie = FakeData.generateDummyMovie()[1]

    @Rule
    @JvmField
    var activityRule : ActivityTestRule<DetailMovieActivity> =
        object: ActivityTestRule<DetailMovieActivity>(DetailMovieActivity::class.java) {

            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailMovieActivity::class.java)
                result.putExtra("movieId", dummyMovie.id)
                return result
            }
        }

    @Before
    fun setUp () {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_textOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_RatingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.backdropMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_mv_favorite)).perform(click())
    }
}