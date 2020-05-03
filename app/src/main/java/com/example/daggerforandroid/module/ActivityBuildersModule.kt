package com.example.daggerforandroid.module

import com.example.daggerforandroid.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
  abstract  class ActivityBuildersModule {

  @ContributesAndroidInjector
    abstract fun contributesAuthActivity():AuthActivity
}