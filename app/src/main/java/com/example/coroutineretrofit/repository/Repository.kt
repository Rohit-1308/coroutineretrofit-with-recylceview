package com.example.coroutineretrofit.repository

import com.example.coroutineretrofit.api.RetrofitInstance
import com.example.coroutineretrofit.models.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
    suspend fun getPost2(number:Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }
    suspend fun getCustomPost(userId:Int,sort:String,order:String):Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    suspend fun pushPost(post:Post):Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }
}