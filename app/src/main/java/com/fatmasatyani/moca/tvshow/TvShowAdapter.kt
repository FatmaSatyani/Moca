package com.fatmasatyani.moca.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL

class TvShowAdapter(private val listener: (TvShow) -> Unit) : PagedListAdapter<TvShow, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>(){
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val rowItemsBinding = RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow, listener)
        }
    }

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