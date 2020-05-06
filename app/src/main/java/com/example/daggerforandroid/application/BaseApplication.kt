package com.example.daggerforandroid.application

import com.example.daggerforandroid.application.di.component.application.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return  DaggerAppComponent.builder().application(this).build()
    }
}