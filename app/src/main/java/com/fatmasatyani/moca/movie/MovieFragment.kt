package com.fatmasatyani.moca.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.FragmentMovieBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private var movieList: MutableList<Movie> = mutableListOf()
    private lateinit var binding: FragmentMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    private var page = 1

//    companion object {
//        @JvmStatic
//        fun newInstance() = MovieFragment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = MovieAdapter(requireContext()) { movie ->
                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                intent.putExtra("movieId", movie.id)
                startActivity(intent)
            }

            loadMovie()
            binding.rvMovies.adapter = adapter
            binding.rvMovies.layoutManager = GridLayoutManager(context,2)
            binding.rvMovies.setHasFixedSize(true)
        }
    }

    private fun loadMovie() {
        Log.d("HOMELOG",page.toString())
        viewModel.page = page
        viewModel.getMovie().observe(viewLifecycleOwner, Observer { movie ->
            movieList.addAll(movie)
            Log.d("HOMECHECK",movieList[0].posterPath)
            adapter.setMovies(movieList)
        })
    }

    private fun obtainViewModel(requireActivity: FragmentActivity): MovieViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity.application)
        return ViewModelProviders.of(requireActivity, factory)[MovieViewModel::class.java]
    }
}

