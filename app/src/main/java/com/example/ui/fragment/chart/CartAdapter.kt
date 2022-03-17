package com.example.ui.fragment.chart

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.R
import com.example.ecommerce.databinding.WishListItemBinding
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.ui.fragment.favorite.FavoriteAdapter

class CartAdapter(val list: List<CartProductData>, val context: Context, val viewModel: CartViewModel) : RecyclerView.Adapter<CartAdapter.ViewHolder>(){
    inner class ViewHolder( val binding: WishListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.wish_list_item, parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text=list[position].title

        Glide.with(holder.binding.itemImage.context)
            .load(list[position].image)
            .into(holder.binding.itemImage)

        holder.binding.delete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setMessage(R.string.alertDeleteMessage)
            builder.setPositiveButton(R.string.yes) { _, _ ->
                viewModel.deleteOnCartItem(list[position])
            }
            builder.setNegativeButton(R.string.no, null)
            builder.show()

        }

    }

    override fun getItemCount(): Int {
        return  list.size
    }


}