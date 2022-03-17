package com.example.ui.fragment.chart

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.fragment.favorite.FavoriteViewModel
import com.example.ui.fragment.profile.AuthRepo
import com.example.ui.fragment.profile.SharedPreferencesProvider
import com.example.ui.repository.Repository
import kotlinx.coroutines.launch

class CartViewModel(application: Application, val repo: AuthRepo): AndroidViewModel(application) {
    private val repositry = Repository(RetrofitInstance.api,application)


    fun deleteOnCartItem(cartProduct: CartProductData)=viewModelScope.launch {
        repositry.deleteOnCartItem(cartProduct)
    }
    fun getAllCartList(): LiveData<List<CartProductData>> {
        return  repositry.getAllCartList()
    }
    class Factory(
        private val application: Application,
        private val authRepo: AuthRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CartViewModel(application, authRepo) as T
        }
    }

    companion object {
        fun create(context: Fragment): CartViewModel {
            return ViewModelProvider(
                context,
                Factory(
                    context.context?.applicationContext as Application,
                    AuthRepo(
                        RetrofitInstance.api,
                        SharedPreferencesProvider(context.context?.applicationContext as Application),
                        context.context?.applicationContext as Application
                    )
                )
            )[CartViewModel::class.java]
        }
    }
}