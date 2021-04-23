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

class ListDogAdapter(private val listDog: ArrayList<Dog>) : RecyclerView.Adapter<ListDogAdapter.ListViewHolder>() {

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
        val dog = listDog[position]
        Glide.with(holder.itemView.context)
            .load(dog.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = dog.name
        holder.tvDetail.text = dog.detail

        holder.tvName.setOnClickListener {
            val context = it.context
            val dogDetailIntent = Intent(context, DetailHewanActivity::class.java)
            dogDetailIntent.putExtra(DetailHewanActivity.EXTRA_LIST, "Dog")
            dogDetailIntent.putExtra(DetailHewanActivity.EXTRA_POSITION, position)
            context.startActivity(dogDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return listDog.size
    }

}