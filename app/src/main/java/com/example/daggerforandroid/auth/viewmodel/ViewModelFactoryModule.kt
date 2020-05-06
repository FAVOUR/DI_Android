package com.example.daggerforandroid.auth.viewmodel

import com.example.daggerforandroid.di.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
 abstract class ViewModelFactoryModule {

    @Binds
    abstract  fun bindFactory(viewModelProviderFactory: ViewModelProviderFactory):  ViewModelProviderFactory
}