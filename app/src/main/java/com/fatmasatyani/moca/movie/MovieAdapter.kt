package com.fatmasatyani.moca.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL

class MovieAdapter(private val listener: (Movie) -> Unit) : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie, listener)
        }
    }

    class MovieViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, listener: (Movie) -> Unit) {
            with(binding) {
                itemTitle.text = movie.title
                itemView.setOnClickListener{listener(movie)}

                Glide.with(itemView.context)
                        .load("$IMG_URL${movie.posterPath}")
                        .into(itemPoster)
            }
        }
    }
}
