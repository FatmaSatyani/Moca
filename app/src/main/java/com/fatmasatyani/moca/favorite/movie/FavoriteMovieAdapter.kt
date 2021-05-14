package com.fatmasatyani.moca.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.moca.utils.Constant

class FavoriteMovieAdapter (private val listener: (Movie) -> Unit) : PagedListAdapter<Movie, FavoriteMovieAdapter.MovieViewHolder> (DIFF_CALLBACK){

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
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
        fun bind(movie: Movie, listener: (Movie) -> Unit) {
            with(binding) {
                favTitle.text = movie.title
                favRating.rating = movie.voteAverage

                itemView.setOnClickListener{listener(movie)}

                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${movie.posterPath}")
                    .transform(RoundedCorners(20))
                    .into(binding.favImage)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}


