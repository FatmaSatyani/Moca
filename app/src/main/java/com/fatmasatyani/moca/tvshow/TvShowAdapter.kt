package com.fatmasatyani.moca.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.databinding.RowItemsBinding
import com.fatmasatyani.moca.detail.DetailActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(tvshow: List<TvShowEntity>?) {
        if (tvshow.isNullOrEmpty()) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val rowItemsBinding =
            RowItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(rowItemsBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: RowItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                itemTitle.text = tvShow.tvShowTitle
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, tvShow.tvShowId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "tvShow")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.tvShowDisplayPicture)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                            .error(R.drawable.ic_baseline_error_outline_24)
                    )
                    .into(itemPoster)
            }
        }
    }
}