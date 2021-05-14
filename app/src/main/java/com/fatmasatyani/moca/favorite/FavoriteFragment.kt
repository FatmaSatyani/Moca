package com.fatmasatyani.moca.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatmasatyani.moca.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    private lateinit var favoriteAdapter: FavoriteViewPagerAdapter
    private lateinit var binding: FragmentFavoriteBinding

    companion object {
        @JvmStatic
        fun newInstance() = FavoriteFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteAdapter = FavoriteViewPagerAdapter(view.context, requireActivity().supportFragmentManager)
        binding.favoriteViewpager.adapter = favoriteAdapter
        binding.favoriteTab.setupWithViewPager(binding.favoriteViewpager)
    }

}