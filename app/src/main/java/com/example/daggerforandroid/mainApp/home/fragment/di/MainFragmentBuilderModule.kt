package com.example.daggerforandroid.mainApp.home.fragment.di

import com.example.daggerforandroid.mainApp.home.fragment.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
   abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFragmentModule(): ProfileFragment
}