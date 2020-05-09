package com.example.daggerforandroid.auth.netwotk

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
     @GET("users/{id}")
    fun getUsers(@Path("id")  id:Int): Call<Response>
}