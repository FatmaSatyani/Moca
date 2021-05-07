package com.fatmasatyani.moca.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL

class MovieAdapter(private val listener: (Movie) -> Unit) :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies : MutableList<Movie> = mutableListOf()

    fun setMovies(movies: List<Movie>) {
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie,listener)
    }

    override fun getItemCount(): Int = listMovies.size

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
