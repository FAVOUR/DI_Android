package com.example.daggerforandroid.auth.di.module

import com.example.daggerforandroid.auth.di.viewmodel.AuthViewModel
import com.example.daggerforandroid.application.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract  fun bindAuthViewModel():AuthViewModel
}