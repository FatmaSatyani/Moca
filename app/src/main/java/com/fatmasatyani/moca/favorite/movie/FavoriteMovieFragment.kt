package com.fatmasatyani.moca.favorite.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.moca.databinding.FragmentMovieBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment(), FavoriteMovieAdapter.OnItemClickCallback {

    private var _favoriteMovieFragmentBinding: FragmentMovieBinding? = null
    private val binding get() = _favoriteMovieFragmentBinding

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteMovieFragmentBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.getFavMovie().observe(viewLifecycleOwner, { favMovie ->
//            if (favMovie != null) {
//                adapter.submitList(favMovie)
//            }
//        })
//    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = FavoriteMovieAdapter { movie ->
                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                intent.putExtra("movieId", movie.id)
                startActivity(intent)
            }

            binding?.rvMovies?.adapter = adapter
            binding?.rvMovies?.layoutManager = LinearLayoutManager(requireContext())
            binding?.rvMovies?.setHasFixedSize(true)
        }
    }

        private fun obtainViewModel(requireActivity: FragmentActivity): FavoriteMovieViewModel {
            val factory = ViewModelFactory.getInstance(requireActivity.application)
            return ViewModelProviders.of(requireActivity, factory)[FavoriteMovieViewModel::class.java]
        }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (activity != null) {
//            viewModel = obtainViewModel(requireActivity())
//            viewModel = ViewModelProvider(this,factory) [FavoriteMovieViewModel::class.java]
//
//            adapter = FavoriteMovieAdapter()
//            adapter.setOnItemClickCallback(this)
//
//            viewModel.getFavMovie().observe(viewLifecycleOwner, { favMovie ->
//                if (favMovie != null) {
//                    adapter.submitList(favMovie)
//                }
//            })
//            }
//        }

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