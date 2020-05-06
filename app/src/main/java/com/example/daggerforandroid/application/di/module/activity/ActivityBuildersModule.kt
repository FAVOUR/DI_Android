package com.example.daggerforandroid.application.di.module.activity

import com.example.daggerforandroid.auth.activity.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *Strictly for Activity declarations meant for contributing to the Android Injector Graph
 **/
@Module
  abstract  class ActivityBuildersModule {

  @ContributesAndroidInjector(
    modules = [ActivityBuildersModule::class]
  )
    abstract fun contributesAuthActivity(): AuthActivity
}