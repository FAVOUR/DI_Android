package com.example.daggerforandroid.mainApp.auth.di.module

import com.example.daggerforandroid.mainApp.auth.services.AuthApi
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