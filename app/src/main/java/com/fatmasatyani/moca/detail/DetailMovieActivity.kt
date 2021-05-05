package com.fatmasatyani.moca.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.ActivityDetailMovieBinding
import com.fatmasatyani.moca.viewmodel.ViewModelFactory
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion.factory
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter.Companion.factory
import okhttp3.internal.platform.android.ConscryptSocketAdapter.Companion.factory

class DetailMovieActivity : AppCompatActivity() {

    private var movieId: Int = 0
    private lateinit var detailViewModel: DetailMovieViewModel
    private lateinit var aMovie: Movie

//    private lateinit var toolbar: Toolbar
//    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
//    private lateinit var itemViewPager: ViewPager
//    private lateinit var appBarLayout: AppBarLayout
//    var movie: String = "Movie"

    private lateinit var detailBinding: ActivityDetailMovieBinding

//    companion object {
//        const val EXTRA_MOVIE = "extra_movie"
//        const val EXTRA_TYPE = "extra_type"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

//        progressBar.show()

        movieId = intent.getIntExtra("movieId", 0)
//        tvShowId = intent.getIntExtra("tvShowId", 0)

        detailViewModel = obtainViewModel(this)
        detailViewModel.movieId = movieId
//        detailViewModel.tvShowId = tvShowId

        detailViewModel.setSelectedMovie().observe(this, Observer { movie ->
            aMovie = movie

            detailBinding.tvTitle.text = movie.title
            detailBinding.tvRelease.text = movie.releaseDate
            detailBinding.tvRuntime.text = movie.runtime.toString()
            detailBinding.tvTextOverview.text = movie.overview
            detailBinding.ratingBar.rating = (movie.voteAverage / 2)
            Glide.with(this)
                .load(movie.backdropPath)
                .transform(RoundedCorners(20))
                .into(detailBinding.imageView)
            Glide.with(this)
                .load(movie.posterPath)
                .transform(RoundedCorners(20))
                .into(detailBinding.detailPoster)

        })
    }

    private fun obtainViewModel(detailActivity: DetailMovieActivity): DetailMovieViewModel {
        val factory = ViewModelFactory.getInstance(detailActivity.application)
        return ViewModelProviders.of(detailActivity, factory).get(DetailMovieViewModel::class.java)
    }
}
//        toolbar = findViewById(R.id.detail_toolbar)
//        collapsingToolbarLayout = findViewById(R.id.detail_toolbar_layout)
//        appBarLayout = findViewById(R.id.detail_app_bar)

//        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

//        val extras = intent.extras
//        if (extras != null) {
//            val movieId = extras.getString(EXTRA_MOVIE)
//            val movieType = extras.getString(EXTRA_TYPE)
//            if (movieId == null || movieType == null) return
//
//            when (movieType) {
//                movie -> {
//
//                    aMovie = movie
////                    populateMovie(detailViewModel.movieId(movieId))
////                    viewModel.setSelectedMovie(movieId)
////                    initViewPager(movieId, "")
//                }
//                else -> {
//                    populateTvShow(viewModel.getTvShow(movieId))
//                    viewModel.setSelectedTvShow(movieId)
//                    initViewPager("",movieId)
//                }
//            }
//        }






//    private fun populateMovie(movie: MovieEntity) {
//        collapsingToolbarLayout.title = movie.movieTitle
//        Glide.with(this)
//            .load(movie.movieDisplayPicture)
//            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
//                .error(R.drawable.ic_baseline_error_outline_24))
//            .into(detail_background)
//        Glide.with(this)
//            .load(movie.movieDisplayPicture)
//            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
//                .error(R.drawable.ic_baseline_error_outline_24))
//            .into(detailBinding.detailPoster)
//        btn_play.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.movieTrailer))
//            startActivity(intent)
//        }
//    }
//
//    private fun populateTvShow(tvSHow: TvShow) {
//        collapsingToolbarLayout.title = tvSHow.tvShowTitle
//        Glide.with(this)
//            .load(tvSHow.tvShowDisplayPicture)
//            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
//                .error(R.drawable.ic_baseline_error_outline_24))
//            .into(detail_background)
//        Glide.with(this)
//            .load(tvSHow.tvShowDisplayPicture)
//            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
//                .error(R.drawable.ic_baseline_error_outline_24))
//            .into(detailBinding.detailPoster)
//        btn_play.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvSHow.tvShowTrailer))
//            startActivity(intent)
//        }
//    }
//
//    private fun initViewPager(movieId: String, movieType: String) {
//        itemViewPager = detail_viewpager
//        itemViewPager.adapter = DetailViewPager(supportFragmentManager, movieId, movieType)
//        detail_tab.setupWithViewPager(itemViewPager)
//    }




