package com.fatmasatyani.moca.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.ui.TvShowAdapter
import com.fatmasatyani.core.utils.Resource
import com.fatmasatyani.core.utils.Status
import com.fatmasatyani.moca.databinding.FragmentTvShowBinding
import com.fatmasatyani.moca.detail.DetailTvShowActivity

class TvShowFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            adapter = TvShowAdapter()
            adapter.notifyDataSetChanged()
        }

        binding.rvTvShows.apply {
            adapter = adapter
            layoutManager = GridLayoutManager(context,2)
            setHasFixedSize(true)
        }

        adapter.setOnItemClick { it ->
            val intent = Intent(activity, DetailTvShowActivity::class.java)
            intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, it)
            startActivity(intent)
            setList()
        }
    }

    private fun setList() {
        viewModel.getTvShow().observe(viewLifecycleOwner,tvShowObserver)
    }

    private val tvShowObserver = Observer<Resource<List<TvShowModel>>>{
        if(it != null) {
            when (it) {
                is Resource.Loading -> setDataState(Status.LOADING)
                is Resource.Success -> setDataState(Status.SUCCESS)
                is Resource.Error -> {
                    setDataState(Status.ERROR)
                    Toast.makeText(context,"Maaf, terjadi kesalahan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setDataState(state: Status) {
        when (state) {
            Status.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                binding.tvBlank.visibility = View.GONE
            }
            Status.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.tvBlank.visibility = View.GONE
            }
            Status.ERROR -> {
                binding.progressBar.visibility = View.GONE
                binding.tvBlank.visibility = View.VISIBLE
            }
        }
    }
}