package com.example.coroutineretrofit.api

import com.example.coroutineretrofit.models.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postnumber}")
    suspend fun getPost2(
        @Path("postnumber") number:Int
    ):Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId:Int,
        @Query("_sort ") sort:String,
        @Query("_order ") order:String
    ):Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ):Response<Post>


}