package com.fatmasatyani.moca.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.detail.DetailActivity

class MovieAdapter :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
//        if (movies == null) return
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                itemTitle.text = movie.movieTitle
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.movieId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(movie.movieDisplayPicture)
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_outline_24))
                        .into(itemPoster)
            }
        }
    }
}
