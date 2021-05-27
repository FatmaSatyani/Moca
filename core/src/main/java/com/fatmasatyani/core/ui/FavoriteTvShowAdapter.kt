package com.fatmasatyani.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.core.constant.Constant
import com.fatmasatyani.core.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel

class FavoriteTvShowAdapter : RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvShowViewHolder>() {

    private val roundingCorners = 20

    private val favoriteTvShow = mutableListOf<FavoriteTvShowModel>()

    private lateinit var onItemClickCallback: (favoriteTvShow: FavoriteTvShowModel) -> Unit

    fun setOnItemClickCallback (onItemClickCallback: (favoriteTvShow: FavoriteTvShowModel) -> Unit) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val itemMovieBinding = FavoriteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteTvShowViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val favoriteTvShow = favoriteTvShow[position]
        holder.bind(favoriteTvShow)
    }

    override fun getItemCount(): Int {
        return favoriteTvShow.size
    }

    fun setDataSet(it: List<FavoriteTvShowModel>) {
        if (it == null) return
        this.favoriteTvShow.clear()
        this.favoriteTvShow.addAll(favoriteTvShow)
        notifyDataSetChanged()
    }

    inner class FavoriteTvShowViewHolder(private val binding: FavoriteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(favoriteTvShow: FavoriteTvShowModel) {
            with(binding) {
                favTitle.text = favoriteTvShow.name
                favRating.rating = favoriteTvShow.voteAverage

                itemView.setOnClickListener{onItemClickCallback.invoke(favoriteTvShow)}

                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${favoriteTvShow.poster}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(binding.favImage)
            }
        }
    }
}


