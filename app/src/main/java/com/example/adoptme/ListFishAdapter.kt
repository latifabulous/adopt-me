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

class ListFishAdapter(private val listFish: ArrayList<Fish>) : RecyclerView.Adapter<ListFishAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val fish = listFish[position]
        Glide.with(holder.itemView.context)
            .load(fish.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = fish.name
        holder.tvDetail.text = fish.detail

        holder.tvName.setOnClickListener {
            val context = it.context
            val fishDetailIntent = Intent(context, DetailHewanActivity::class.java)
            fishDetailIntent.putExtra(DetailHewanActivity.EXTRA_LIST, "Fish")
            fishDetailIntent.putExtra(DetailHewanActivity.EXTRA_POSITION, position)
            context.startActivity(fishDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return listFish.size
    }

}