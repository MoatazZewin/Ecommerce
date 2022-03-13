package com.example.ui.fragment.favorite

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.R
import com.example.ecommerce.databinding.WishListItemBinding
import com.example.model.local.favoriteRoom.FavoriteProduct

class FavoriteAdapter(val list: List<FavoriteProduct> ,val context: Context,val viewModel: FavoriteViewModel) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    inner class ViewHolder( val binding: WishListItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
            R.layout.wish_list_item, parent, false
        )
        )
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        holder.binding.title.text=list[position].title

        Glide.with(holder.binding.itemImage.context)
            .load(list[position].image)
            .into(holder.binding.itemImage)

        holder.binding.delete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setMessage(R.string.alertDeleteMessage)
            builder.setPositiveButton(R.string.yes) { _, _ ->
                viewModel.delete(list[position])
            }
            builder.setNegativeButton(R.string.no, null)
            builder.show()

        }

    }

    override fun getItemCount(): Int {
      return  list.size
    }
}