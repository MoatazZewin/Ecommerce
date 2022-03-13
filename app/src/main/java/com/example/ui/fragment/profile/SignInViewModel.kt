package com.example.ui.fragment.profile

import android.app.Application
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.model.dataClass.customer.CustomersModel
import com.example.model.retrofit.RetrofitInstance.api

import kotlinx.coroutines.launch


class SignInViewModel(application: Application, val AuthRepo: AuthRepo) :
    AndroidViewModel(application) {

    val loginSuccess: MutableLiveData<Boolean?> = MutableLiveData()


    @RequiresApi(Build.VERSION_CODES.M)
    fun getData(email: String) {
        viewModelScope.launch {
            val response: Either<CustomersModel, LoginErrors> = AuthRepo.signIn(email)

            when (response) {
                is Either.Error -> when (response.errorCode) {
                    LoginErrors.NoInternetConnection -> {
                        Toast.makeText(
                            getApplication(),
                            "NoInternetConnection" + response.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    LoginErrors.ServerError -> {

                        Toast.makeText(
                            getApplication(),
                            "ServerError" + response.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    LoginErrors.CustomerNotFound -> {
                        Toast.makeText(
                            getApplication(),
                            "CustomerNotFound" + response.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                is Either.Success -> {
                    Log.d("singin", "" + response.data)
                    loginSuccess.postValue(true)
                }
            }
        }
    }


    class Factory(private val application: Application, val AuthRepo: AuthRepo) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SignInViewModel(application, AuthRepo) as T
        }
    }

    companion object {
        fun create(context: Fragment): SignInViewModel {
            return ViewModelProvider(
                context,
                Factory(
                    context.context?.applicationContext as Application,
                    AuthRepo(
                        api,
                        SharedPreferencesProvider(context.context?.applicationContext as Application),

                        context.context?.applicationContext as Application
                    )
                )
            )[SignInViewModel::class.java]
        }
    }
}