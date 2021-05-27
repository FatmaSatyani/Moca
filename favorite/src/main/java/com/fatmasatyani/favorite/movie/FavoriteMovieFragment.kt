package com.fatmasatyani.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.ui.FavoriteMovieAdapter
import com.fatmasatyani.di.favoriteMovieModule
import com.fatmasatyani.moca.databinding.FragmentFavoriteMovieBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteMovieFragment : Fragment() {

    private var _favoriteMovieFragmentBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _favoriteMovieFragmentBinding

    private val viewModel by viewModel<FavoriteMovieViewModel>()
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(favoriteMovieModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteMovieFragmentBinding =
            FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)

        viewModel.favoriteMovie.observe(viewLifecycleOwner, Observer { it ->
            result(it)
        })

        adapter.setOnItemClickCallback {
//            val favMovie = DataMapper.mapFavMovieToMovie(it)
            val intent = Intent(requireContext(), DetailMovieActivity::class.java)
            intent.putExtra("movieId", it.MovId)
            startActivity(intent)
        }
        with(binding?.rvFavoriteMovie) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.adapter = adapter
            this?.setHasFixedSize(true)
        }
        return binding?.root
    }

    private fun result(it: List<FavoriteMovieModel>) {
        binding?.progressBar?.visibility = View.GONE
        binding?.tvBlank?.visibility = if (it.isNullOrEmpty()) View.VISIBLE else View.GONE
        adapter.setDataSet(it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _favoriteMovieFragmentBinding = null
    }
}
//            adapter = FavoriteMovieAdapter { movie ->
//                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
//                intent.putExtra("movieId", movie.movieId)
//                startActivity(intent)
//            }
//            adapter.setOnItemClickCallback(this)
//
//            viewModel.getFavMovie().observe(viewLifecycleOwner, {
//                if (it != null) {
//                adapter.submitList(it)}
//            })

//        lifecycleScope.launchWhenCreated {
//            adapter = FavoriteMovieAdapter()
//            adapter.notifyDataSetChanged()
//
////            binding?.rvFavoriteMovie?.apply {
////                layoutManager = LinearLayoutManager(requireContext())
////                adapter = adapter
////                setHasFixedSize(true)
////            }
//
//            adapter.setOnItemClickCallback(object: FavoriteMovieAdapter.OnItemClickCallback)
//        }
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        if (activity != null) {
//            viewModel = obtainViewModel(requireActivity())
//            adapter = FavoriteMovieAdapter { movie ->
//                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
//                intent.putExtra("movieId", movie.movieId)
//                startActivity(intent)
//            }
//            adapter.setOnItemClickCallback(this)
//
//            viewModel.getFavMovie().observe(viewLifecycleOwner, {
//                if (it != null) {
//                adapter.submitList(it)}
//            })
//
//            binding?.rvFavoriteMovie?.adapter = adapter
//            binding?.rvFavoriteMovie?.layoutManager = LinearLayoutManager(requireContext())
//            binding?.rvFavoriteMovie?.setHasFixedSize(true)
//        }
//    }
//
//        private fun obtainViewModel(requireActivity: FragmentActivity): FavoriteMovieViewModel<Any?> {
//            val factory = ViewModelFactory.getInstance(requireActivity.application)
//            return ViewModelProviders.of(
//                requireActivity,
//                factory
//            )[FavoriteMovieViewModel::class.java]
//        }

        //


//        override fun onItemClicked(id: String) {
//            val intent = Intent(context, DetailMovieActivity::class.java)
//            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
//            context?.startActivity(intent)
//        }

