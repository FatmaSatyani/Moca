package com.fatmasatyani.moca.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.TvShowEntity
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*
import com.fatmasatyani.moca.tvshow.TvShowViewModel as TvShowViewModel


class TvShowFragment : Fragment() {
    private lateinit var tvShowList: List<TvShowEntity>

    private val tvShowViewModel by lazy {
        ViewModelProvider(this).get(TvShowViewModel::class.java)
    }

    private val tvShowAdapter by lazy {
        TvShowAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvShowList = tvShowViewModel.tvShow
        rv_tvShows.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@TvShowFragment.tvShowAdapter
        }
        tvShowAdapter.setTvShow(tvShowList)
    }
}