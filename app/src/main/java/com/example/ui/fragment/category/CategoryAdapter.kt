package com.example.ui.fragment.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.model.dataClass.product.Product


class ItemCategoryAdapter(var categoryItems:List<Product>, var context: Context, var onClick:ItemRecyclerClick): RecyclerView.Adapter<ItemCategoryAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            CategaryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Glide.with(context).load(categoryItems.get(position).images?.get(0)?.src).into(holder.binding.imageProduct)
        holder.binding.tvDesc.text=""+categoryItems.get(position).title
        holder.itemView.setOnClickListener {
            onClick.itemOnClick(categoryItems.get(position).id.toLong())
        }
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }
    class ItemViewHolder(val binding: CategaryItemBinding): RecyclerView.ViewHolder(binding.root)
}