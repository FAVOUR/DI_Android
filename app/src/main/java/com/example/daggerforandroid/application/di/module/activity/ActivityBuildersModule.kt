package com.example.daggerforandroid.application.di.module.activity

import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.mainApp.auth.di.module.AuthApiModule
import com.example.daggerforandroid.mainApp.auth.di.module.AuthViewModelModule
import com.example.daggerforandroid.mainApp.home.HomeActivity
import com.example.daggerforandroid.mainApp.home.di.module.ProfileViewModelModule
import com.example.daggerforandroid.mainApp.home.fragment.di.MainFragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *Strictly for Activity declarations meant for contributing to the Android Injector Graph
 **/
@Module
  abstract  class ActivityBuildersModule {

  @ContributesAndroidInjector(
    modules = [AuthViewModelModule::class, AuthApiModule::class]
  )
    abstract fun contributesAuthActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class,ProfileViewModelModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}