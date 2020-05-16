package com.example.daggerforandroid.mainApp.home.fragment.di

import com.example.daggerforandroid.mainApp.home.fragment.PostFragment
import com.example.daggerforandroid.mainApp.home.fragment.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
   abstract class HomeFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragmentModule(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragmentModule(): PostFragment
}