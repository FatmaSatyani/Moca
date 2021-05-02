package com.fatmasatyani.moca.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.MovieEntity
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieList: List<MovieEntity>

    private val movieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    private val movieAdapter by lazy {
        MovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movieList = movieViewModel.movies
        rv_movies.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@MovieFragment.movieAdapter
        }
        movieAdapter.setMovies(movieList)
    }
}
