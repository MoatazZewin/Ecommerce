package com.example.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.model.dataClass.brand.SmartCollections

class ProductDetailAdapter (val context: Context) :
    RecyclerView.Adapter<ProductDetailAdapter.AdapterProductViewHolder>(){
    private val brandsList: ArrayList<SmartCollections> = ArrayList()
    fun addList(myList:ArrayList<SmartCollections>){
        this.brandsList.clear()
        brandsList.addAll(myList)
    }

    inner class AdapterProductViewHolder(binding: CategaryItemBinding): RecyclerView.ViewHolder(binding.root) {
        val tvDesc=binding.tvDesc
        val imageProduct=binding.imageProduct

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )=AdapterProductViewHolder (
        CategaryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: ProductDetailAdapter.AdapterProductViewHolder, position: Int) {
        holder.tvDesc.text=brandsList[position].title.toString()
        Glide.with(context).apply {
            load(brandsList[position].image?.src).into(holder.imageProduct)
        }


    }

    override fun getItemCount(): Int =brandsList.size

}