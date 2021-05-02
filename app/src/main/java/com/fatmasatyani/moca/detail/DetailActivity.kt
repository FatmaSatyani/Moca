package com.fatmasatyani.moca.detail

import android.content.Intent
import android.graphics.Movie
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.databinding.ActivityDetailBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var itemViewPager: ViewPager
    private lateinit var appBarLayout: AppBarLayout
    var movie: String = "Movie"

    private lateinit var detailBinding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        toolbar = findViewById(R.id.detail_toolbar)
        collapsingToolbarLayout = findViewById(R.id.detail_toolbar_layout)
        appBarLayout = findViewById(R.id.detail_app_bar)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val movieType = extras.getString(EXTRA_TYPE)
            if (movieId == null || movieType == null) return

            when (movieType) {
                movie -> {
                    populateMovie(viewModel.getMovie(movieId))
                    viewModel.setSelectedMovie(movieId)
                    initViewPager(movieId, "")
                }
                else -> {
                    populateTvShow(viewModel.getTvShow(movieId))
                    viewModel.setSelectedTvShow(movieId)
                    initViewPager("",movieId)
                }
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        collapsingToolbarLayout.title = movie.movieTitle
        Glide.with(this)
            .load(movie.movieDisplayPicture)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_error_outline_24))
            .into(detail_background)
        Glide.with(this)
            .load(movie.movieDisplayPicture)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_error_outline_24))
            .into(detailBinding.detailPoster)
        btn_play.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.movieTrailer))
            startActivity(intent)
        }
    }

    private fun populateTvShow(tvSHow: TvShowEntity) {
        collapsingToolbarLayout.title = tvSHow.tvShowTitle
        Glide.with(this)
            .load(tvSHow.tvShowDisplayPicture)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_error_outline_24))
            .into(detail_background)
        Glide.with(this)
            .load(tvSHow.tvShowDisplayPicture)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_error_outline_24))
            .into(detailBinding.detailPoster)
        btn_play.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvSHow.tvShowTrailer))
            startActivity(intent)
        }
    }

    private fun initViewPager(movieId: String, movieType: String) {
        itemViewPager = detail_viewpager
        itemViewPager.adapter = DetailViewPager(supportFragmentManager, movieId, movieType)
        detail_tab.setupWithViewPager(itemViewPager)
    }
}



