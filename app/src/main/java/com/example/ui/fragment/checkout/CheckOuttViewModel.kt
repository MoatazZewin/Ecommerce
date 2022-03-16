package com.example.ui.fragment.checkout

import android.app.Application

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.fragment.profile.AuthRepo
import com.example.ui.fragment.profile.SharedPreferencesProvider


class CheckOuttViewModel(application: Application, private val authRepo: AuthRepo) :
    AndroidViewModel(application) {

    val orderSuccess: MutableLiveData<Boolean?> = MutableLiveData()

//    @RequiresApi(Build.VERSION_CODES.M)
//    fun postOrder(order: Order) {
//        viewModelScope.launch {
//            when (val response: Either<OrderResponce, RepoErrors> =
//                authRepo.createOrder(order)) {
//                is Either.Error -> when (response.errorCode) {
//                    RepoErrors.ConnectionFiled -> {
//                        Toast.makeText(
//                            getApplication(),
//                            "NoInternetConnection" + response.message,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                    RepoErrors.ServerError -> {
//
//                        Toast.makeText(
//                            getApplication(),
//                            "ServerError" + response.message,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//                is Either.Success -> orderSuccess.postValue(true)
//            }
//        }
//    }


    class Factory(
        private val application: Application,
        val authRepo: AuthRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CheckOuttViewModel(application, authRepo) as T
        }
    }

    companion object {
        fun create(context: Fragment): CheckOuttViewModel {
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
            )[CheckOuttViewModel::class.java]
        }
    }

}