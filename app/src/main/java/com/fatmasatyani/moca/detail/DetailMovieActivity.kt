package com.fatmasatyani.moca.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.ActivityDetailMovieBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private var movieId: Int = 0
    private lateinit var detailViewModel: DetailMovieViewModel
    private lateinit var aMovie: Movie
    private lateinit var detailBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()

        movieId = intent.getIntExtra("movieId", 0)

        detailViewModel = obtainViewModel(this)
        detailViewModel.movieId = movieId

        detailViewModel.setSelectedMovie().observe(this, Observer { movie ->
            aMovie = movie

            detailBinding.tvTitle.text = movie.title
            detailBinding.tvRelease.text = movie.releaseDate
            detailBinding.tvRuntime.text = movie.runtime.toString()
            detailBinding.tvTextOverview.text = movie.overview
            detailBinding.ratingBar.rating = (movie.voteAverage / 2)
            Glide.with(this)
                .load("$IMG_URL${movie.backdropPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.imageView)
            Glide.with(this)
                .load("$IMG_URL${movie.posterPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.detailPoster)
            detailBinding.progressBar.hide()
        })
    }

    private fun obtainViewModel(detailActivity: DetailMovieActivity): DetailMovieViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailMovieViewModel::class.java)
    }
}
