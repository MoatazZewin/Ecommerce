package com.example.ui.fragment.profile

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.model.retrofit.RetrofitInstance

class ConfirmSigninViewModel(application: Application,
                             val authenticationRepo: AuthRepo
) : AndroidViewModel(application) {
    class Factory(
        private val application: Application,
        private val authRepo: AuthRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ConfirmSigninViewModel(application, authRepo) as T
        }
    }

    companion object {
        fun create(context: Fragment): ConfirmSigninViewModel {
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
            )[ConfirmSigninViewModel::class.java]
        }
    }
}