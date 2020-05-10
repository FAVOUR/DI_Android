package com.example.daggerforandroid.auth.services

import com.example.daggerforandroid.auth.model.User
import io.reactivex.Flowable
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

     @GET("users/{id}")
    fun getUser(@Path("id")  id:Int): Flowable<User>

}