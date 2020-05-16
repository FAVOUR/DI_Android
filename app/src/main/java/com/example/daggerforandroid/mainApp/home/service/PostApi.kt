package com.example.daggerforandroid.mainApp.home.service

import com.example.daggerforandroid.mainApp.home.model.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    // /posts?userId=1/
    @GET("posts")
    fun getPostsFromUser(
        @Query("userId") id: Int
    ): Flowable<List<Post?>?>?
}