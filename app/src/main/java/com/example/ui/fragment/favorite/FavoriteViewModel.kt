package com.example.ui.fragment.favorite

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.fragment.profile.AuthRepo
import com.example.ui.fragment.profile.SharedPreferencesProvider
import com.example.ui.repository.Repository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application, val repo:AuthRepo): AndroidViewModel(application) {

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

    class Factory(
        private val application: Application,
        private val authRepo: AuthRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FavoriteViewModel(application, authRepo) as T
        }
    }

    companion object {
        fun create(context: Fragment): FavoriteViewModel {
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
            )[FavoriteViewModel::class.java]
        }
    }


}