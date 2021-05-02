package com.fatmasatyani.moca.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.movie.MovieViewModel
import com.fatmasatyani.moca.tvshow.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment: Fragment() {

    companion object {
        const val ARG_MOVIE_ID = "extra_movie"
        const val ARG_TVSHOW_ID = "extra_tvshow"

        fun newInstance(movieId: String, tvShowId: String): DescriptionFragment {
            val args = Bundle()
            args.putString(ARG_MOVIE_ID, movieId)
            args.putString(ARG_TVSHOW_ID,tvShowId)
            val fragment = DescriptionFragment()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_description,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieId = arguments?.getString(ARG_MOVIE_ID)
        val tvShowId = arguments?.getString(ARG_TVSHOW_ID)

            val movie = movieId?.let { movieViewModel.getMovies(it) }
            if (movie != null) {
                getDataMovie(movie)
                return
            }
            val tvShow = tvShowId?.let { tvShowViewModel.getTvShow(it) }
            getDataTvShow(tvShow)
    }

    private fun getDataMovie(movie: MovieEntity?) {
        tv_desc.text = movie?.movieDescription
    }

    private fun getDataTvShow(tvShow: TvShowEntity?) {
        tv_desc.text = tvShow?.tvShowDescription
    }
}

