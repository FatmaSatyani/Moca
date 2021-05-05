package com.fatmasatyani.moca.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.FragmentMovieBinding
import com.fatmasatyani.moca.databinding.FragmentTvShowBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity
import com.fatmasatyani.moca.detail.DetailTvShowActivity
import com.fatmasatyani.moca.movie.MovieAdapter
import com.fatmasatyani.moca.movie.MovieFragment
import com.fatmasatyani.moca.movie.MovieViewModel
import com.fatmasatyani.moca.viewmodel.ViewModelFactory
import com.fatmasatyani.moca.tvshow.TvShowViewModel as TvShowViewModel


class TvShowFragment : Fragment() {

    private var tvShowList: MutableList<TvShow> = mutableListOf()
    private lateinit var binding: FragmentTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

//    companion object {
//        @JvmStatic
//        fun newInstance() = MovieFragment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = TvShowAdapter(requireContext()) {
                val intent = Intent (requireContext(), DetailTvShowActivity::class.java)
                intent.putExtra("tvShowId", id)
                startActivity(intent)
            }

            loadTvShow()
            binding.rvTvShows.adapter = adapter
            binding.rvTvShows.layoutManager = LinearLayoutManager(context)
            binding.rvTvShows.setHasFixedSize(true)
        }
    }

    private fun loadTvShow() {
        viewModel.getTvShow().observe(viewLifecycleOwner, Observer { tvShow ->
            tvShowList.addAll(tvShow)
            adapter.setTvShows(tvShowList)
        })
    }

    private fun obtainViewModel(requireActivity: FragmentActivity): TvShowViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity.application)
        return ViewModelProviders.of(this,factory)[TvShowViewModel::class.java]
//        return viewModel
    }
}