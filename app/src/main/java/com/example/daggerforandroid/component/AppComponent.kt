package com.example.daggerforandroid.component

import android.app.Application
import com.example.daggerforandroid.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
     modules = [
                AndroidInjectionModule::class]
)
interface AppComponent:AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        fun build():AppComponent

        @BindsInstance
        fun application(appComponent:Application):Builder
    }
}