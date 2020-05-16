package com.example.daggerforandroid.mainApp.home.di.module

import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.di.keys.ViewModelKey
import com.example.daggerforandroid.mainApp.home.viewmodel.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindsPostViewModel(postViewModel: PostViewModel):ViewModel
}