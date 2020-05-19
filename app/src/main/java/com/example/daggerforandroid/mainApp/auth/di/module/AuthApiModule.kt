package com.example.daggerforandroid.mainApp.auth.di.module

import com.example.daggerforandroid.mainApp.auth.model.User
import com.example.daggerforandroid.mainApp.auth.services.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class AuthApiModule {


    @AuthScope
    @Provides
    @Named("auth_user") //This is how to differentiate a method that has the same type so there can possibly identify teh variable been referred to
    fun someUser(): User? {
        return User()
    }


    @AuthScope
    @Provides
    fun getApi (retrofit: Retrofit):AuthApi{
        return retrofit.create(AuthApi::class.java)
    }

}