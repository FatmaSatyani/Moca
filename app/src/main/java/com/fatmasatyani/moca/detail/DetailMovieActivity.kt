package com.fatmasatyani.moca.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.core.constant.Constant.Companion.IMG_URL
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.databinding.ActivityDetailMovieBinding
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.google.android.material.snackbar.Snackbar

class DetailMovieActivity : AppCompatActivity() {

    private val roundingCorners = 20

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailViewModel: DetailMovieViewModel
    private lateinit var detailBinding: ActivityDetailMovieBinding
    private lateinit var mMovie: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()
        detailBinding.btnMvFavorite.setOnClickListener { }

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (detailMovie != null) {
            populateDetail(detailMovie)
        }
    }
//        movieId = intent.getIntExtra("movieId", 0)
//
//        detailViewModel = obtainViewModel(this)
//        detailViewModel.movieId = movieId

//        detailViewModel.setSelectedMovie().observe(this, {
//            val movie = it.data
//            if (movie != null) {
//                mMovie = movie
//                detailBinding.apply {
//                    tvMovieTitle.text = movie.title
//                    tvMovieRelease.text = movie.releaseDate
//                    tvMovieRuntime.text = movie.runtime.toString()
//                    tvMovieTextOverview.text = movie.overview
//                    movieRatingBar.rating = (movie.voteAverage / 2)
//                    Glide.with(this@DetailMovieActivity)
//                        .load("$IMG_URL${movie.backdropPath}")
//                        .transform(RoundedCorners(roundingCorners))
//                        .into(backdropMovie)
//                    Glide.with(this@DetailMovieActivity)
//                        .load("$IMG_URL${movie.posterPath}")
//                        .transform(RoundedCorners(roundingCorners))
//                        .into(detailMoviePoster)
//                    progressBar.hide()
//                }
//
//                favoriteState()
//            }


    private fun populateDetail(movie: Movie) {
        with(detailBinding) {
            detailBinding.apply {
                tvMovieTitle.text = movie.title
                tvMovieRelease.text = movie.releaseDate
                tvMovieRuntime.text = movie.runtime.toString()
                tvMovieTextOverview.text = movie.overview
                movieRatingBar.rating = (movie.voteAverage / 2)
                Glide.with(this@DetailMovieActivity)
                    .load("$IMG_URL${movie.backdropPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(backdropMovie)
                Glide.with(this@DetailMovieActivity)
                    .load("$IMG_URL${movie.posterPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailMoviePoster)
                progressBar.hide()
            }
            favoriteState()
        }
    }

    private fun favoriteState() {
        if (detailViewModel.isFavorite(mMovie)) {
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
            Toast.makeText(baseContext,"${mMovie.movieTitle} removed from Favorite", Toast.LENGTH_SHORT).show()
        } else {
            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
            Toast.makeText(baseContext,"${mMovie.movieTitle} added to Favorite", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun fabOnClick() {
//        if (detailViewModel.isFavorite(mMovie)) {
//            detailViewModel.removeFavorite(mMovie)
//            Snackbar.make(detailBinding.scrollView,"${mMovie.movieTitle} removed from Favorite", Snackbar.LENGTH_SHORT).show()
//            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
//        } else {
//            detailViewModel.addFavorite(mMovie)
//            Snackbar.make(detailBinding.scrollView, "${mMovie.movieTitle} added to Favorite", Snackbar.LENGTH_SHORT).show()
//            detailBinding.btnMvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
//        }
//    }

//    private fun obtainViewModel(detailActivity: DetailMovieActivity): DetailMovieViewModel {
//        val factory = ViewModelFactory.getInstance(detailActivity.application)
//        return ViewModelProvider(detailActivity, factory).get(DetailMovieViewModel::class.java)
//    }
}
