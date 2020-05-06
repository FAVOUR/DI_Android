package com.example.daggerforandroid.di.module.activity

import com.example.daggerforandroid.auth.activity.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *Strictly for Activity declarations meant for contributing to the Android Injector Graph
 **/
@Module
  abstract  class ActivityBuildersModule {

  @ContributesAndroidInjector
    abstract fun contributesAuthActivity(): AuthActivity
}