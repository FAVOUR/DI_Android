package com.example.daggerforandroid.mainApp.home.di.module

import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.di.keys.ViewModelKey
import com.example.daggerforandroid.mainApp.home.viewmodel.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
  interface HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel
}