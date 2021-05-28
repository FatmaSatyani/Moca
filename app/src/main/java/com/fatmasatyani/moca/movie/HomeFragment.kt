package com.fatmasatyani.moca.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.core.ui.MovieAdapter
import com.fatmasatyani.core.utils.Resource
import com.fatmasatyani.moca.databinding.FragmentHomeBinding
import com.fatmasatyani.moca.detail.DetailActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDataState()
        binding.fabFavorite.setOnClickListener(this)
        binding.progressBar.visibility = View.VISIBLE

//        lifecycleScope.launchWhenCreated {
//            adapter = MovieAdapter()
//            adapter.notifyDataSetChanged()
//        }

        adapter.setOnItemClick {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(it)
            findNavController().navigate(action)

            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_MOVIE, it)
            intent.putExtra("movieId", it.movieId)
            startActivity(intent)
        }

        binding.rvMovies.apply {
            adapter = adapter
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
        }
//        adapter.setOnItemClick { it ->
//            val intent = Intent(activity, DetailActivity::class.java)
//            intent.putExtra(DetailActivity.EXTRA_MOVIE, it)
//            intent.putExtra("movieId", it.movieId)
//            startActivity(intent)
//        }

    }

    override fun onClick(it: View?) {
        when (it) {
            binding.fabFavorite -> {
                val action = HomeFragmentDirections.actionHomeFragmentToFavoriteMovieFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun setDataState() {
        viewModel.movie.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    adapter.setDataSet(it.data)
                    binding.progressBar.visibility = View.GONE
                    binding.tvBlank.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.tvBlank.visibility = View.GONE
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvBlank.visibility = View.VISIBLE
                    Toast.makeText(context, "Sorry, something went wrong", Toast.LENGTH_SHORT).show()
                }
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


