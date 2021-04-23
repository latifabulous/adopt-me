package com.example.adoptme

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridCatAdapter(val listCat: ArrayList<Cat>) : RecyclerView.Adapter<GridCatAdapter.GridViewHolder>() {

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_cat, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val cat = listCat[position]
        Glide.with(holder.itemView.context)
            .load(cat.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = cat.name
        holder.tvDetail.text = cat.detail

        holder.tvName.setOnClickListener {
            val context = it.context
            val catDetailIntent = Intent(context, DetailHewanActivity::class.java)
            catDetailIntent.putExtra(DetailHewanActivity.EXTRA_LIST, "Cat")
            catDetailIntent.putExtra(DetailHewanActivity.EXTRA_POSITION, position)
            context.startActivity(catDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return listCat.size
    }
}