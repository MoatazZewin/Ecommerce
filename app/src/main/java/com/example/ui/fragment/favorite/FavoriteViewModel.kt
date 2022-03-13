package com.example.ui.fragment.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.repository.Repository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private val repositry = Repository(RetrofitInstance.api,application)



    fun delete(favoriteProduct: FavoriteProduct)=viewModelScope.launch {
        repositry.delete(favoriteProduct)
    }

    fun getAllFav(): LiveData<List<FavoriteProduct>> {
      return  repositry.getAllFav()
    }

    fun getOneItem(id:Long) {
        repositry.getOneItem(id)
    }


}