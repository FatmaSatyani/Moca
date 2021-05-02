package com.fatmasatyani.moca.about

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.DetailEntity
import kotlinx.android.synthetic.main.row_about_items.view.*

class AboutAdapter (private val context: Context?, private val listMovies: ArrayList<DetailEntity>): RecyclerView.Adapter<AboutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_about_items,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder(listDetail: DetailEntity) {
            itemView.about_position.text = listDetail.position
            itemView.about_name.text = listDetail.name
        }
    }

    fun setDetailList(details: List<DetailEntity>) {
        this.listMovies.clear()
        this.listMovies.addAll(details)
        notifyDataSetChanged()
    }
}