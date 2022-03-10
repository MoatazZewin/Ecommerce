package com.example.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.model.dataClass.product.Product

class ProductsAdapter (val context: Context, val onBrandClickListener:OnBrandClickListner) :
    RecyclerView.Adapter<ProductsAdapter.AdapterProductViewHolder>(){
    private val brandsList: ArrayList<Product> = ArrayList()
    fun addList(myList:List<Product>){
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

    override fun onBindViewHolder(holder: ProductsAdapter.AdapterProductViewHolder, position: Int) {
        holder.tvDesc.text=brandsList[position].title.toString()
        Glide.with(context).apply {
            load(brandsList[position].image?.src).into(holder.imageProduct)
        }

    }

    override fun getItemCount(): Int =brandsList.size
    interface OnBrandClickListner{

    }
}