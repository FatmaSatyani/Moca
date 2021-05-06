package com.fatmasatyani.moca.detail

import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.ActivityDetailMovieBinding
import com.fatmasatyani.moca.databinding.ActivityDetailTvShowBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    private var tvShowId: Int = 0
    private lateinit var detailViewModel: DetailTvShowViewModel
    private lateinit var aTvShow: TvShow
    private lateinit var detailBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()

        tvShowId = intent.getIntExtra("tvShowId", 0)
        Log.d("TESTING","$tvShowId")

        detailViewModel = obtainViewModel(this)
        detailViewModel.tvShowId = tvShowId

        detailViewModel.setSelectedTvShow().observe(this, Observer { tvShow ->
            aTvShow = tvShow

            detailBinding.tvTitle.text = tvShow.name
            detailBinding.tvRelease.text = tvShow.firstAirDate
            detailBinding.tvTextOverview.text = tvShow.overview
            detailBinding.ratingBar.rating = (tvShow.voteAverage / 2)
            Glide.with(this)
                .load("$IMG_URL${tvShow.backdropPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.imageView)
            Glide.with(this)
                .load("$IMG_URL${tvShow.posterPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.detailPoster)
            detailBinding.progressBar.hide()
        })
    }


    private fun obtainViewModel(detailActivity: DetailTvShowActivity): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailTvShowViewModel::class.java)
    }
}
