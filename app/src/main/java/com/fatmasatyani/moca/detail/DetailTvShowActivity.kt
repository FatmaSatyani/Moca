package com.fatmasatyani.moca.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.ActivityDetailTvShowBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    private var tvShowId: Int = 1
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

        detailViewModel.setSelectedTvShow().observe(this, { tvShow ->
            aTvShow = tvShow

            detailBinding.tvTvShowTitle.text = tvShow.name
            detailBinding.tvTvShowRelease.text = tvShow.firstAirDate
            detailBinding.tvTvShowTextOverview.text = tvShow.overview
            detailBinding.tvShowRatingBar.rating = (tvShow.voteAverage / 2)
            Glide.with(this)
                .load("$IMG_URL${tvShow.backdropPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.backdropTvShow)
            Glide.with(this)
                .load("$IMG_URL${tvShow.posterPath}")
                .transform(RoundedCorners(20))
                .into(detailBinding.detailTvShowPoster)
            detailBinding.progressBar.hide()
        })
    }


    private fun obtainViewModel(detailActivity: DetailTvShowActivity): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailTvShowViewModel::class.java)
    }
}
