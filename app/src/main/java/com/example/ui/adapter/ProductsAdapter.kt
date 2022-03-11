package com.example.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.model.dataClass.product.Product

class ProductsAdapter (val context: Context, val onProductClickListner:OnProductClickListner) :
    RecyclerView.Adapter<ProductsAdapter.AdapterProductViewHolder>(){
    private val ProductList: ArrayList<Product> = ArrayList()
    fun addList(myList:List<Product>){
        this.ProductList.clear()
        ProductList.addAll(myList)
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
        holder.tvDesc.text=ProductList[position].title.toString()
        Glide.with(context).apply {
            load(ProductList[position].image?.src).into(holder.imageProduct)
        }

        holder.itemView.setOnClickListener {
            onProductClickListner.onProductClick(ProductList[position],position)

        }

    }

    override fun getItemCount(): Int =ProductList.size
    interface OnProductClickListner{
        fun onProductClick(mylist:Product,position: Int)


    }
}