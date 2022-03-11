package com.example.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.R
import com.example.model.dataClass.productdetail.Images

class PagerAdapter (val context: Context) : RecyclerView.Adapter<PagerAdapter.ImageViewHolder>() {

    private var list: ArrayList<Images> = ArrayList()

    fun setContentList(list: ArrayList<Images>) {
        this.list.clear()
        this.list.addAll(list)

    }

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = itemView.findViewById<ImageView>(R.id.imageDetail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = list[position]
        holder.apply {
            Glide.with(context).load(image.src).into(imageView)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}