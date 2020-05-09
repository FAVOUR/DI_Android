package com.example.daggerforandroid.auth.di.module

import com.example.daggerforandroid.auth.netwotk.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthApiModule {

    @Provides
    fun getApi (retrofit: Retrofit):AuthApi{
        return retrofit.create(AuthApi::class.java)
    }

}