package com.fatmasatyani.moca.favorite.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.moca.databinding.FragmentFavoriteMovieBinding
import com.fatmasatyani.moca.databinding.FragmentMovieBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment(), FavoriteMovieAdapter.OnItemClickCallback {

    private var _favoriteMovieFragmentBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _favoriteMovieFragmentBinding

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteMovieFragmentBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = FavoriteMovieAdapter { movie ->
                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                intent.putExtra("movieId", movie.movieId)
                startActivity(intent)
            }
            adapter.setOnItemClickCallback(this)

            viewModel.getFavMovie().observe(viewLifecycleOwner, {
                if (it != null) {
                adapter.submitList(it)}
            })

            binding?.rvFavoriteMovie?.adapter = adapter
            binding?.rvFavoriteMovie?.layoutManager = LinearLayoutManager(requireContext())
            binding?.rvFavoriteMovie?.setHasFixedSize(true)
        }
    }

    private fun obtainViewModel(requireActivity: FragmentActivity): FavoriteMovieViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity.application)
        return ViewModelProviders.of(requireActivity, factory)[FavoriteMovieViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _favoriteMovieFragmentBinding = null
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, DetailMovieActivity::class.java )
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE,id)
        context?.startActivity(intent)
    }
}