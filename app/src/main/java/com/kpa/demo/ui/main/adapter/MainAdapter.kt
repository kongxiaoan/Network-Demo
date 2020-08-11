package com.kpa.demo.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kpa.demo.R
import com.kpa.demo.data.model.Girl
import kotlinx.android.synthetic.main.item_layout_main.view.*

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
class MainAdapter(private val girls: ArrayList<Girl>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(girls: Girl) {
            itemView.textViewUserName.text = girls.author
            itemView.textViewUserEmail.text = girls.desc
            println("url = ${girls.url}")
            Glide.with(itemView.imageViewAvatar.context)
                .load(girls.url)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_main, parent, false)
        )


    override fun getItemCount() = girls.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(girls[position])

    fun addData(girls: List<Girl>) {
        this.girls.addAll(girls)
}
}