package com.example.ui.fragment.profile

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.model.dataClass.customer.CustomerModel
import com.example.model.dataClass.customer.CustomersModel
import com.example.model.retrofit.InterfacApi
import com.example.model.retrofit.RetrofitInstance.api


class AuthRepo(
    val ShopifyServices: InterfacApi,
    var sharedPref: SharedPreferencesProvider,
    val application: Application
) { @RequiresApi(Build.VERSION_CODES.M)
    suspend fun signUp(customer: CustomerModel): Either<CustomerModel, RepoErrors> {
        return try {
            return if (Connectivity.isOnline(application.applicationContext)) {
                val res = api.register(customer)
                if (res.isSuccessful) {
                    sharedPref.update {
                        it.copy(customer = res.body()?.customer)
                    }
                    Log.d("customerINFO",res.body()?.customer.toString())


                    Log.d("body", res.body()?.customer.toString())

                    Either.Success(res.body()!!)
                } else
                    Either.Error(RepoErrors.ServerError, res.message())
            } else
                Either.Error(RepoErrors.NoInternetConnection, "NoInternetConnection")

        } catch (t: Throwable) {
            Either.Error(RepoErrors.ServerError, t.message)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun signIn(email: String): Either<CustomersModel, LoginErrors> {
        return try {
            if (Connectivity.isOnline(application.applicationContext)) {
                val res = ShopifyServices.login()
                if (res.isSuccessful) {

                    val customer = res.body()?.customer?.first {
                        it?.email.equals(email)
                    } ?: return Either.Error(LoginErrors.CustomerNotFound, "CustomerNotFound")

                    sharedPref.update {
                        it.copy(
                            customer = customer
                        )
                    }
                    Log.d("signBody", res.body()!!.customer.toString())

                    return Either.Success(res.body()!!)
                } else
                    return Either.Error(LoginErrors.ServerError, res.message())
            } else
                return Either.Error(LoginErrors.NoInternetConnection, "NoInternetConnection")

        } catch (t: Throwable) {
            Either.Error(LoginErrors.ServerError, t.message)
        }
    }


   }