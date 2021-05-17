package com.fatmasatyani.moca.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.ActivityDetailMovieBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.fatmasatyani.moca.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class DetailMovieActivity : AppCompatActivity() {

    private val roundingCorners = 20

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private var movieId: Int = 1
    private lateinit var detailViewModel: DetailMovieViewModel
    private lateinit var detailBinding: ActivityDetailMovieBinding
    private lateinit var mMovie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()

        movieId = intent.getIntExtra("movieId", 0)

        detailViewModel = obtainViewModel(this)
        detailViewModel.movieId = movieId

        detailViewModel.setSelectedMovie().observe(this, {
            val movie = it.data

            if (movie != null) {
                mMovie = movie
                detailBinding.tvMovieTitle.text = movie.title
                detailBinding.tvMovieRelease.text = movie.releaseDate
                detailBinding.tvMovieRuntime.text = movie.runtime.toString()
                detailBinding.tvMovieTextOverview.text = movie.overview
                detailBinding.movieRatingBar.rating = (movie.voteAverage / 2)
                Glide.with(this)
                    .load("$IMG_URL${movie.backdropPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailBinding.backdropMovie)
                Glide.with(this)
                    .load("$IMG_URL${movie.posterPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailBinding.detailMoviePoster)
                detailBinding.progressBar.hide()

                favoriteState()
            }
        })
        detailBinding.btnMvFavorite.setOnClickListener { fabOnClick()}
    }

    private fun favoriteState() {
        if (detailViewModel.isFavorite(mMovie)) {
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
        } else {
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun fabOnClick() {
        if (detailViewModel.isFavorite(mMovie)) {
            detailViewModel.removeFavorite(mMovie)
            Snackbar.make(detailBinding.scrollView,"${mMovie.title} removed from Favorite", Snackbar.LENGTH_SHORT).show()
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
        } else {
            detailViewModel.addFavorite(mMovie)
            Snackbar.make(detailBinding.scrollView, "${mMovie.title} added to Favorite", Snackbar.LENGTH_SHORT).show()
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
        }
    }

    private fun obtainViewModel(detailActivity: DetailMovieActivity): DetailMovieViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailMovieViewModel::class.java)
    }
}
