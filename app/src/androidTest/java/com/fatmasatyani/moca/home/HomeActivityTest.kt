package com.fatmasatyani.moca.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import com.fatmasatyani.moca.utils.FakeData
import kotlinx.coroutines.delay
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = FakeData.generateDummyMovie()
    private val dummyTvShow = FakeData.generateDummyTvShow()
    private val dummyFavoriteMovie = FakeData.getFavoriteDummyMovie()
    private val dummyFavoriteTvShow = FakeData.getFavoriteDummyTvShow()

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
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
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

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,click()))
        onView(withId(R.id.tv_tvShow_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvShow_release)).check(matches(isDisplayed()))
        onView(withId(R.id.scrollView)).perform(swipeUp())
        onView(withId(R.id.tv_tvShow_textOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShow_RatingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvShow_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.backdrop_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_tv_favorite)).perform(click())
    }

    @Test
    fun loadFavorite() {
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

    @Test
    fun loadFavorite2() {
        onView(withText("FAVORITE")).perform(click())
        onView(withText("FAV TV SHOW")).perform(click())
        onView(withId(R.id.rv_favorite_tv_show)).perform(click())
        onView(withId(R.id.rv_favorite_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavoriteTvShow.size))
        onView(withId(R.id.rv_favorite_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
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