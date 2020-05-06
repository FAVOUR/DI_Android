package com.example.daggerforandroid.application.di.module.viewmodel

import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
 abstract class ViewModelFactoryModule {

    @Binds
    abstract  fun bindFactory(viewModelProviderFactory: ViewModelProviderFactory):  ViewModelProviderFactory
}