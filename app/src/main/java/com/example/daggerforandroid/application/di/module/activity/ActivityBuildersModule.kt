package com.example.daggerforandroid.application.di.module.activity

import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.mainApp.auth.di.module.AuthApiModule
import com.example.daggerforandroid.mainApp.auth.di.module.AuthViewModelModule
import com.example.daggerforandroid.mainApp.home.HomeActivity
import com.example.daggerforandroid.mainApp.home.di.module.PostApiModule
import com.example.daggerforandroid.mainApp.home.di.module.HomeViewModelModule
import com.example.daggerforandroid.mainApp.home.di.module.PostViewModelModule
import com.example.daggerforandroid.mainApp.home.fragment.di.HomeFragmentBuilderModule
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

    @ContributesAndroidInjector(modules = [HomeFragmentBuilderModule::class,HomeViewModelModule::class, PostApiModule::class, PostViewModelModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}