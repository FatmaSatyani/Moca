package com.fatmasatyani.moca.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.moca.databinding.FragmentTvShowBinding
import com.fatmasatyani.moca.detail.DetailTvShowActivity
import com.fatmasatyani.moca.favorite.movie.FavoriteMovieViewModel
import com.fatmasatyani.moca.viewmodel.ViewModelFactory


class FavoriteTvShowFragment : Fragment() , FavoriteTvShowAdapter.OnItemClickCallback {

    private var _favoriteTvShowFragmentBinding: FragmentTvShowBinding? = null
    private val binding get() = _favoriteTvShowFragmentBinding

    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var adapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteTvShowFragmentBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = FavoriteTvShowAdapter { tvShow ->
                val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                intent.putExtra("tvShowId", tvShow.tvShowId)
                startActivity(intent)
            }

            viewModel.getFavTvShow().observe(viewLifecycleOwner, {
                if (it != null) {
                    adapter.submitList(it)}
            })

            binding?.rvTvShows?.adapter = adapter
            binding?.rvTvShows?.layoutManager = LinearLayoutManager(requireContext())
            binding?.rvTvShows?.setHasFixedSize(true)
        }
    }

    private fun obtainViewModel(requireActivity: FragmentActivity): FavoriteTvShowViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity.application)
        return ViewModelProviders.of(requireActivity, factory)[FavoriteTvShowViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _favoriteTvShowFragmentBinding = null
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, DetailTvShowActivity::class.java )
        intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW,id)
        context?.startActivity(intent)
    }

}
