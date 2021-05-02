package com.fatmasatyani.moca.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.DetailEntity
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.description.DescriptionFragment
import com.fatmasatyani.moca.movie.MovieViewModel
import com.fatmasatyani.moca.tvshow.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {

    private lateinit var detailList: List<DetailEntity>

    companion object {
        private const val ARG_MOVIE_ID = "extra_movie"
        private const val ARG_TVSHOW_ID = "extra_tvshow"

        fun newInstance(movieId: String, tvShowId: String): AboutFragment {
            val args = Bundle()
            args.putString(ARG_MOVIE_ID, movieId)
            args.putString(ARG_TVSHOW_ID, tvShowId)
            val fragment = AboutFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    private val tvShowViewModel by lazy {
        ViewModelProvider(this).get(TvShowViewModel::class.java)
    }

    private val aboutAdapter by lazy {
        AboutAdapter(context, arrayListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieId = arguments?.getString(DescriptionFragment.ARG_MOVIE_ID)
        val tvShowId = arguments?.getString(DescriptionFragment.ARG_TVSHOW_ID)
            val movie = movieId?.let { movieViewModel.getMovies(it) }
            if (movie != null) {
                getDataMovie(movie)
                return
            }
            val tvShow = tvShowId?.let { tvShowViewModel.getTvShow(it) }
            getDataTvShow(tvShow)
    }

    private fun getDataMovie(movies: MovieEntity?) {
        movies?.detailEntity?.let { recyclerviewData(it) }
    }

    private fun getDataTvShow(tvShow: TvShowEntity?) {
        tvShow?.detailEntity?.let { recyclerviewData(it) }
    }

    private fun recyclerviewData(detailEntity: List<DetailEntity>) {
        detailList = detailEntity
        rv_about.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@AboutFragment.aboutAdapter
        }
        aboutAdapter.setDetailList(detailList)
    }
}


