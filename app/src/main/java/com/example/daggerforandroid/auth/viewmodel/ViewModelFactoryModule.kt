package com.example.daggerforandroid.auth.viewmodel

import dagger.Binds
import dagger.Module

@Module
 abstract class ViewModelFactoryModule {

    @Binds
    abstract  fun viewModelFactoty
}