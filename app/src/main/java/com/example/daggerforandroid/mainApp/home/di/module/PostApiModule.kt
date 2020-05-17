package com.example.daggerforandroid.mainApp.home.di.module

import androidx.recyclerview.widget.RecyclerView
import com.example.daggerforandroid.mainApp.home.recyclerview.PostsRecyclerAdapter
import com.example.daggerforandroid.mainApp.home.service.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PostApiModule {

    @Provides
    fun providesPosts(retrofit:Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    fun providesRecyclerView():PostsRecyclerAdapter{
        return PostsRecyclerAdapter()
    }
}