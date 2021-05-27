package com.fatmasatyani.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.ui.FavoriteTvShowAdapter
import com.fatmasatyani.core.utils.Resource
import com.fatmasatyani.di.favoriteTvShowModule
import com.fatmasatyani.moca.databinding.FragmentFavoriteTvShowBinding
import com.fatmasatyani.moca.detail.DetailTvShowActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules


class FavoriteTvShowFragment : Fragment() {

    private var _favoriteTvShowFragmentBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _favoriteTvShowFragmentBinding

    private val viewModel by viewModel<FavoriteTvShowViewModel>()
    private lateinit var adapter: FavoriteTvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(favoriteTvShowModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteTvShowFragmentBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)

        viewModel.favoriteTvShow.observe(viewLifecycleOwner, Observer { it ->
            result(it)
        })

        adapter.setOnItemClickCallback {
//            val favMovie = DataMapper.mapFavMovieToMovie(it)
            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
            intent.putExtra("tvShowId", it.tvShowId)
            startActivity(intent)
        }
        with(binding?.rvFavoriteTvShow) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.adapter = adapter
            this?.setHasFixedSize(true)
        }
        return binding?.root
    }

    private fun result(it: List<FavoriteTvShowModel>) {
        binding?.progressBar?.visibility = View.GONE
        binding?.tvBlank?.visibility = if (it.isNullOrEmpty()) View.VISIBLE else View.GONE
        adapter.setDataSet(it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _favoriteTvShowFragmentBinding = null
    }
}
