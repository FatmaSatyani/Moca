package com.fatmasatyani.moca.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL

class TvShowAdapter(private val listener: (TvShow) -> Unit) :RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShows : MutableList<TvShow> = mutableListOf()

    fun setTvShows(tvShows: List<TvShow>) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow,listener)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow, listener: (TvShow) -> Unit) {
            with(binding) {
                itemTitle.text = tvShow.name
                itemView.setOnClickListener{listener(tvShow)}

                Glide.with(itemView.context)
                    .load("$IMG_URL${tvShow.posterPath}")
                    .into(itemPoster)
            }
        }

    }
}