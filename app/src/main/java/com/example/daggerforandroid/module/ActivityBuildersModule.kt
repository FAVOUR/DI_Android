package com.example.daggerforandroid.module

import com.example.daggerforandroid.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 *Strictly for Activity declarations meant for contributing to the Android Injector Graph
 **/
@Module
  abstract  class ActivityBuildersModule {

  @ContributesAndroidInjector
    abstract fun contributesAuthActivity():AuthActivity
}