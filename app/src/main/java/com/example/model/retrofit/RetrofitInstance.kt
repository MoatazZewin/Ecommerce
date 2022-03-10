package com.example.model.retrofit

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import androidx.viewbinding.BuildConfig
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object RetrofitInstance {


    const val apiKey = "bfe73f4cd7e7f8737d5928b2a439022e"
    const val password = "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"
    const val BASE_URL = "https://$apiKey:$password@jets2022.myshopify.com/admin/api/2022-01/"

    private lateinit var retrofit: Retrofit
    val retro: Retrofit by lazy {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildAuthClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit
    }
    var api = retro.create(InterfacApi::class.java)
    private fun authInterceptor(chain: Interceptor.Chain): Response {
        val credentials = Credentials.basic(apiKey, password);
        return chain.proceed(
            chain.request().newBuilder().header("Authorization", credentials)
                .build()
        )
    }

    private fun buildAuthClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(provideLoggingInterceptor())
            .addInterceptor(::authInterceptor)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        return httpClient
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        @Suppress("ConstantConditionIf")
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return interceptor
    }
}


//    companion object {
//
//        private val retrofit by lazy {
//
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(BasciInterceptor("bfe73f4cd7e7f8737d5928b2a439022e","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"))
//                .build()
//
//            Retrofit.Builder()
//                .baseUrl("https://jets2022.myshopify.com/admin/api/2022-01/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        }
//        val api by lazy {
//              retrofit.create( InterfacApi::class.java)
//        }
//
//    }


