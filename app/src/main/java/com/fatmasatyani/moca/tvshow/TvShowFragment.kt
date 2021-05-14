package com.fatmasatyani.moca.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.FragmentTvShowBinding
import com.fatmasatyani.moca.detail.DetailTvShowActivity
import com.fatmasatyani.moca.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private var tvShowList: MutableList<TvShow> = mutableListOf()
    private lateinit var binding: FragmentTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = TvShowAdapter { tvShow ->
                val intent = Intent (requireContext(), DetailTvShowActivity::class.java)
                intent.putExtra("tvShowId", tvShow.id)
                startActivity(intent)
            }

            loadTvShow()
            binding.rvTvShows.adapter = adapter
            binding.rvTvShows.layoutManager = GridLayoutManager(context,2)
            binding.rvTvShows.setHasFixedSize(true)
        }
    }

    private fun loadTvShow() {
        viewModel.page = page
        viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
            adapter.submitList(tvShow.data)
        })
    }

    private fun obtainViewModel(requireActivity: FragmentActivity): TvShowViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity.application)
        return ViewModelProviders.of(requireActivity,factory)[TvShowViewModel::class.java]
    }
}