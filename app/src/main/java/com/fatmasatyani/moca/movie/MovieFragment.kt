package com.fatmasatyani.moca.movie

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
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.ui.MovieAdapter
import com.fatmasatyani.core.utils.Resource
import com.fatmasatyani.core.utils.Status
import com.fatmasatyani.moca.databinding.FragmentMovieBinding
import com.fatmasatyani.moca.detail.DetailMovieActivity

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            adapter = MovieAdapter()
            adapter.notifyDataSetChanged()
        }

        binding.rvMovies.apply {
                adapter = adapter
                layoutManager = GridLayoutManager(context,2)
                setHasFixedSize(true)
        }

        adapter.setOnItemClick { it ->
            val intent = Intent(activity,DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, it)
            startActivity(intent)
            setList()
        }
    }

    private fun setList() {
        viewModel.getMovie().observe(viewLifecycleOwner,movieObserver)
    }

    private val movieObserver = Observer<Resource<List<MovieModel>>>{
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

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        if (activity != null) {
//            viewModel = obtainViewModel(requireActivity())
//            adapter = MovieAdapter { movie ->
//                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
//                intent.putExtra("movieId", movie.id)
//                startActivity(intent)
//            }
//
//            loadMovie()
//            binding.rvMovies.apply {
//                adapter = adapter
//                layoutManager = GridLayoutManager(context,2)
//                setHasFixedSize(true)
//            }
//        }
//    }

//    private fun loadMovie() {
//        viewModel.page = page
//        viewModel.getMovie().observe(viewLifecycleOwner, { movie ->
//            adapter.submitList(movie.data)
//        })
//    }

//    private fun obtainViewModel(requireActivity: FragmentActivity): MovieViewModel {
//        val factory = ViewModelFactory.getInstance(requireActivity.application)
//        return ViewModelProvider(requireActivity, factory)[MovieViewModel::class.java]
//    }


