package com.example.daggerforandroid.mainApp.auth.di.module

import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.di.keys.ViewModelKey
import com.example.daggerforandroid.auth.viewmodel.AuthViewModel
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
