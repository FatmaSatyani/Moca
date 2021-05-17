package com.fatmasatyani.moca.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.moca.utils.Constant

class FavoriteMovieAdapter (private val listener: (FavoriteMovieData) -> Unit) : PagedListAdapter<FavoriteMovieData, FavoriteMovieAdapter.MovieViewHolder>(DIFF_CALLBACK){

    private val roundingCorners = 20

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteMovieData>() {
            override fun areContentsTheSame(oldItem: FavoriteMovieData, newItem: FavoriteMovieData): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: FavoriteMovieData, newItem: FavoriteMovieData): Boolean {
                return oldItem.movieId == newItem.movieId
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = FavoriteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie,listener)
        }
    }

    inner class MovieViewHolder(private val binding: FavoriteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: FavoriteMovieData, listener: (FavoriteMovieData) -> Unit) {
            with(binding) {
                favTitle.text = movie.title
                favRating.rating = movie.voteAverage

                itemView.setOnClickListener{listener(movie)}

                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${movie.posterPath}")
                    .transform(RoundedCorners(roundingCorners))
                    .into(binding.favImage)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }

}


