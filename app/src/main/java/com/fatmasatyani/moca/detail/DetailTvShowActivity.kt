package com.fatmasatyani.moca.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.core.constant.Constant.Companion.IMG_URL
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.databinding.ActivityDetailTvShowBinding
import com.fatmasatyani.moca.utils.hide
import com.fatmasatyani.moca.utils.show
import com.google.android.material.snackbar.Snackbar

class DetailTvShowActivity : AppCompatActivity() {

    private val roundingCorners = 20

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailViewModel: DetailTvShowViewModel
    private lateinit var detailBinding: ActivityDetailTvShowBinding
    private lateinit var mTvShow: TvShowModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailBinding.progressBar.show()
        detailBinding.btnTvFavorite.setOnClickListener { }

        val detailTvShow = intent.getParcelableExtra<TvShow>(EXTRA_TVSHOW)
        if (detailTvShow != null) {
            populateDetail(detailTvShow)
        }
    }

    private fun populateDetail(tvShow: TvShow) {
        with(detailBinding) {
            detailBinding.apply {
                tvTvShowTitle.text = tvShow.name
                tvTvShowTextOverview.text = tvShow.overview
                tvShowRatingBar.rating = (tvShow.voteAverage / 2)
                tvTvShowRelease.text = tvShow.firstAirDate
                Glide.with(this@DetailTvShowActivity)
                    .load("$IMG_URL${tvShow.backdropPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(backdropTvShow)
                Glide.with(this@DetailTvShowActivity)
                    .load("$IMG_URL${tvShow.posterPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(detailTvShowPoster)
                progressBar.hide()
            }
            favoriteState()
        }
    }

//        tvShowId = intent.getIntExtra("tvShowId", 0)
//
//        detailViewModel = obtainViewModel(this)
//        detailViewModel.tvShowId = tvShowId
//
//        detailViewModel.setSelectedTvShow().observe(this, {
//
//            val tvShow = it.data
//
//            if (tvShow != null) {
//                mTvShow = tvShow
//                detailBinding.apply {
//                    tvTvShowTitle.text = tvShow.name
//                    tvTvShowRelease.text = tvShow.firstAirDate
//                    tvTvShowTextOverview.text = tvShow.overview
//                    tvShowRatingBar.rating = (tvShow.voteAverage / 2)
//                    Glide.with(this@DetailTvShowActivity)
//                        .load("$IMG_URL${tvShow.backdropPath}")
//                        .transform(RoundedCorners(roundingCorners))
//                        .into(backdropTvShow)
//                    Glide.with(this@DetailTvShowActivity)
//                        .load("$IMG_URL${tvShow.posterPath}")
//                        .transform(RoundedCorners(roundingCorners))
//                        .into(detailTvShowPoster)
//                    progressBar.hide()
//                }
//                favoriteState()
//            }
//        })
//        detailBinding.btnTvFavorite.setOnClickListener { fabOnClick()}
//    }

    private fun favoriteState() {
        if (detailViewModel.isFavorite(mTvShow)) {
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
            Toast.makeText(baseContext,"${mTvShow.tvShowName} removed from Favorite", Toast.LENGTH_SHORT).show()
        } else {
            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
            Toast.makeText(baseContext,"${mTvShow.tvShowName} added to Favorite", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun fabOnClick() {
//        if (detailViewModel.isFavorite(mTvShow)) {
//            detailViewModel.removeFavorite(mTvShow)
//            Snackbar.make(detailBinding.scrollView,"${mTvShow.name} removed from Favorite", Snackbar.LENGTH_SHORT).show()
//            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_border_24)
//        } else {
//            detailViewModel.addFavorite(mTvShow)
//            Snackbar.make(detailBinding.scrollView, "${mTvShow.name} added to Favorite", Snackbar.LENGTH_SHORT).show()
//            detailBinding.btnTvFavorite.setBackgroundColor(R.drawable.ic_baseline_favorite_24)
//        }
//    }

//    private fun obtainViewModel(detailActivity: DetailTvShowActivity): DetailTvShowViewModel {
//        val factory = ViewModelFactory.getInstance(detailActivity.application)
//        return ViewModelProvider(detailActivity, factory).get(DetailTvShowViewModel::class.java)
//    }
}
