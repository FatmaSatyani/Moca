package com.fatmasatyani.moca.favorite.movie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
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
class FavoriteMovieFragmentTest {

    private val dummyFavoriteMovie = FakeData.getFavoriteDummyMovie()

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
    fun loadFavoriteMovieFragment() {
        onView(withText("FAVORITE")).perform(click())
        onView(withText("FAV MOVIE")).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavoriteMovie.size))
    }

    @Test
    fun loadFavoriteMovieDetail() {
        onView(withText("FAVORITE")).perform(click())
        onView(withText("FAV MOVIE")).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavoriteMovie.size))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_release)).check(matches(isDisplayed()))
        onView(withId(R.id.scrollView)).perform(swipeUp())
        onView(withId(R.id.tv_movie_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_textOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_RatingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.backdropMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_mv_favorite)).perform(click())
    }
}