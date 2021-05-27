package com.fatmasatyani.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.core.constant.Constant
import com.fatmasatyani.core.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.core.domain.model.FavoriteMovieModel

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {

    private val roundingCorners = 20

    private val favoriteMovies = mutableListOf<FavoriteMovieModel>()

    private lateinit var onItemClickCallback: (favoriteMovie: FavoriteMovieModel) -> Unit

    fun setOnItemClickCallback (onItemClickCallback: (favoriteMovie: FavoriteMovieModel) -> Unit) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemMovieBinding = FavoriteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteMovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val favoriteMovie = favoriteMovies[position]
        holder.bind(favoriteMovie)
    }

    override fun getItemCount(): Int {
        return favoriteMovies.size
    }

    fun setDataSet(it: List<FavoriteMovieModel>) {
        if (it == null) return
        this.favoriteMovies.clear()
        this.favoriteMovies.addAll(favoriteMovies)
        notifyDataSetChanged()
    }

    inner class FavoriteMovieViewHolder(private val binding: FavoriteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(favoriteMovie: FavoriteMovieModel) {
            with(binding) {
                favTitle.text = favoriteMovie.title
                favRating.rating = favoriteMovie.voteAverage

                itemView.setOnClickListener{onItemClickCallback.invoke(favoriteMovie)}

                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${favoriteMovie.poster}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(binding.favImage)
            }
        }
    }

}


