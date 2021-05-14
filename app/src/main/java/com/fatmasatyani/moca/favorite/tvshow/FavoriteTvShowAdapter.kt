package com.fatmasatyani.moca.favorite.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL

class FavoriteTvShowAdapter (private val listener: (TvShow) -> Unit) : PagedListAdapter<TvShow, FavoriteTvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK){

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieBinding = FavoriteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TvShowViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow,listener)
        }
    }

    inner class TvShowViewHolder(private val binding: FavoriteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(tvShow: TvShow, listener: (TvShow) -> Unit) {
            with(binding) {
                favTitle.text = tvShow.name
                favRating.rating = tvShow.voteAverage

                itemView.setOnClickListener{listener(tvShow)}

                Glide.with(itemView.context)
                    .load("$IMG_URL${tvShow.posterPath}")
                    .transform(RoundedCorners(20))
                    .into(binding.favImage)
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}


