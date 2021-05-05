package com.fatmasatyani.moca.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.ActivityDetailTvShowBinding
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {
    private var tvShowId: Int = 0

    //    private var tvShowId: Int = 0
    private lateinit var detailViewModel: DetailTvShowViewModel
    private lateinit var aTvShow: TvShow

//    private lateinit var toolbar: Toolbar
//    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
//    private lateinit var itemViewPager: ViewPager
//    private lateinit var appBarLayout: AppBarLayout
//    var movie: String = "Movie"

    private lateinit var detailBinding: ActivityDetailTvShowBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

//        progressBar.show()

        tvShowId = intent.getIntExtra("tvShowId", 0)
//        tvShowId = intent.getIntExtra("tvShowId", 0)

        detailViewModel = obtainViewModel(this)
        detailViewModel.tvShowId = tvShowId
//        detailViewModel.tvShowId = tvShowId

        detailViewModel.setSelectedTvShow().observe(this, Observer { tvShow ->
            aTvShow = tvShow

            detailBinding.tvTitle.text = tvShow.name
            detailBinding.tvRelease.text = tvShow.firstAirDate
//            detailBinding.tvRuntime.text = tvShow.episodeRunTime.toString()
            detailBinding.tvTextOverview.text = tvShow.overview
            detailBinding.ratingBar.rating = (tvShow.voteAverage/2)
            Glide.with(this)
                .load(tvShow.backdropPath)
                .transform(RoundedCorners(20))
                .into(detailBinding.imageView)
            Glide.with(this)
                .load(tvShow.posterPath)
                .transform(RoundedCorners(20))
                .into(detailBinding.detailPoster)

        })
    }

    private fun obtainViewModel(detailActivity: DetailTvShowActivity): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailTvShowViewModel::class.java)
    }
}
