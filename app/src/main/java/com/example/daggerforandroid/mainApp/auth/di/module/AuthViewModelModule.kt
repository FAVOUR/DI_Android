package com.example.daggerforandroid.mainApp.auth.di.module

import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.mainApp.auth.viewmodel.AuthViewModel
import com.example.daggerforandroid.application.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract  fun bindAuthViewModel(auth:AuthViewModel):ViewModel
}