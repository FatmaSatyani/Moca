package com.fatmasatyani.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.core.constant.Constant.Companion.IMG_URL
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.databinding.RowItemsBinding
import com.fatmasatyani.core.domain.model.MovieModel

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<MovieModel>()
    private lateinit var onItemClick: (movie: MovieModel) -> Unit

    fun setOnItemClick(onItemClick: (movie: MovieModel) -> Unit) { this.onItemClick = onItemClick}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = movies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModel) {
            with(binding) {
                itemTitle.text = movie.movieTitle
                itemView.setOnClickListener{onItemClick.invoke(movie)}

                Glide.with(itemView.context)
                    .load("$IMG_URL${movie.moviePoster}")
                    .into(itemPoster)
            }
        }
    }
}

//    DIFF_CALLBACK
//) {
//
//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>(){
//            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MovieViewHolder(rowItemsBinding)
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        val movie = getItem(position)
//        if (movie != null) {
//            holder.bind(movie, listener)
//        }
//    }
//
//    class MovieViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
//        fun bind(movie: Movie, listener: (Movie) -> Unit) {
//            with(binding) {
//                itemTitle.text = movie.title
//                itemView.setOnClickListener{listener(movie)}
//
//                Glide.with(itemView.context)
//                        .load("$IMG_URL${movie.posterPath}")
//                        .into(itemPoster)
//            }
//        }
//    }
//}
