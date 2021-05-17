package com.fatmasatyani.moca.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.ActivityDetailTvShowBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.fatmasatyani.moca.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class DetailTvShowActivity : AppCompatActivity() {

    private val roundingCorners = 20

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private var tvShowId: Int = 1
    private lateinit var detailViewModel: DetailTvShowViewModel
    private lateinit var mTvShow: TvShow
    private lateinit var detailBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()

        tvShowId = intent.getIntExtra("tvShowId", 0)

        detailViewModel = obtainViewModel(this)
        detailViewModel.tvShowId = tvShowId

        detailViewModel.setSelectedTvShow().observe(this, {

            val tvShow = it.data

            if (tvShow != null) {
                mTvShow = tvShow
                detailBinding.tvTvShowTitle.text = tvShow.name
                detailBinding.tvTvShowRelease.text = tvShow.firstAirDate
                detailBinding.tvTvShowTextOverview.text = tvShow.overview
                detailBinding.tvShowRatingBar.rating = (tvShow.voteAverage / 2)
                Glide.with(this)
                    .load("$IMG_URL${tvShow.backdropPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailBinding.backdropTvShow)
                Glide.with(this)
                    .load("$IMG_URL${tvShow.posterPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailBinding.detailTvShowPoster)
                detailBinding.progressBar.hide()

                favoriteState()
            }
        })
        detailBinding.btnTvFavorite.setOnClickListener { fabOnClick()}
    }

    private fun favoriteState() {
        if (detailViewModel.isFavorite(mTvShow)) {
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
        } else {
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun fabOnClick() {
        if (detailViewModel.isFavorite(mTvShow)) {
            detailViewModel.removeFavorite(mTvShow)
            Snackbar.make(detailBinding.scrollView,"${mTvShow.name} removed from Favorite", Snackbar.LENGTH_SHORT).show()
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
        } else {
            detailViewModel.addFavorite(mTvShow)
            Snackbar.make(detailBinding.scrollView, "${mTvShow.name} added to Favorite", Snackbar.LENGTH_SHORT).show()
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
        }
    }

    private fun obtainViewModel(detailActivity: DetailTvShowActivity): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailTvShowViewModel::class.java)
    }
}
