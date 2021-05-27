package com.fatmasatyani.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.core.constant.Constant
import com.fatmasatyani.core.databinding.RowItemsBinding
import com.fatmasatyani.core.domain.model.TvShowModel

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val tvShows = mutableListOf<TvShowModel>()
    private lateinit var onItemClick: (tvShow: TvShowModel) -> Unit

    fun setOnItemClick(onItemClick: (tvShow: TvShowModel) -> Unit) { this.onItemClick = onItemClick}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    inner class TvShowViewHolder(private val binding: RowItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowModel) {
            with(binding) {
                itemTitle.text = tvShow.tvShowName
                itemView.setOnClickListener{onItemClick.invoke(tvShow)}
                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${tvShow.tvShowPoster}")
                    .into(itemPoster)
            }
        }
    }


}