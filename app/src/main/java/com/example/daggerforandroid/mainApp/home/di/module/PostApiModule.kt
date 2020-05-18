package com.example.daggerforandroid.mainApp.home.di.module

import com.example.daggerforandroid.mainApp.home.di.HomeScope
import com.example.daggerforandroid.mainApp.home.recyclerview.PostsRecyclerAdapter
import com.example.daggerforandroid.mainApp.home.service.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PostApiModule {

    @HomeScope
    @Provides
    fun providesPosts(retrofit:Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @HomeScope
    @Provides
    fun providesRecyclerView():PostsRecyclerAdapter{
        return PostsRecyclerAdapter()
    }
}