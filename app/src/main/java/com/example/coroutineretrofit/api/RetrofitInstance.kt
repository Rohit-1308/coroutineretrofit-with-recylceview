package com.example.coroutineretrofit.api

import com.example.coroutineretrofit.utils.Constants.Companion.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit:Retrofit by lazy{
            Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    val api:SimpleApi by lazy{
        retrofit.create(SimpleApi::class.java)
    }
}