package com.example.ui.fragment.category

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.example.Products


class CategoryAdapter(val context:Context): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private var productList = mutableListOf<Products>()
    fun addList(productList: List<Products>) {
        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = MyViewHolder(
        CategaryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val productsModel = productList[position]

        holder.apply {
            tvDesc.text = productsModel.title
            Glide.with(context).apply {
                load(productsModel.image!!.src).into(imageProduct)
            }

//            itemView.setOnClickListener {
//                onItemClickListener.onItemEditClickProduct(productsModel,position)
//            }
        }
    }

    class MyViewHolder(binding: CategaryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvDesc: TextView = binding.tvDesc
        //private val tvPrice: TextView = binding.tvPrice
        val imageProduct: ImageView = binding.imageProduct

    }
}