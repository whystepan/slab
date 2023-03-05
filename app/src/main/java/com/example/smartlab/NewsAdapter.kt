package com.example.smartlab

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsAdapter (private val news: ArrayList<NewsClass>):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNameNews: TextView = itemView.findViewById(R.id.tvNameNews)
        val tvDescNews: TextView = itemView.findViewById(R.id.tvDescNews)
        val tvPriceNews: TextView = itemView.findViewById(R.id.tvPriceNews)
        val imNews: ImageView = itemView.findViewById(R.id.imNews)
        val newsBgItem: ConstraintLayout = itemView.findViewById(R.id.newsBgItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = news.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val new = news[position]
        holder.newsBgItem.tag = new.newsid
        holder.tvPriceNews.text = "${new.newsprice.toString()} ₽ "
        holder.tvNameNews.text = new.newsname
        holder.tvDescNews.text = new.newsdesc
        holder.imNews.clipToOutline = true // ?
        Picasso.get().load(new.newsimg).error(R.drawable.noimg).into(holder.imNews)
    }
}
