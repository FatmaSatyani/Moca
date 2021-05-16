package com.fatmasatyani.moca.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
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

class DetailTvShowActivityTest {

    var dummyTvShow = FakeData.generateDummyTvShow()[1]

    @Rule
    @JvmField
    var activityRule : ActivityTestRule<DetailTvShowActivity> =
        object: ActivityTestRule<DetailTvShowActivity>(DetailTvShowActivity::class.java) {

            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailTvShowActivity::class.java)
                result.putExtra("tvShowId", dummyTvShow.id)
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
    fun loadTvShowDetail() {
        onView(withId(R.id.tv_tvShow_title)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_tvShow_release)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_tvShow_textOverview)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tvShow_RatingBar)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.detail_tvShow_poster)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.backdrop_tvShow)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_tv_favorite)).perform(click())
    }
}