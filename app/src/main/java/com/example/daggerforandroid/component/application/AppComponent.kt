package com.example.daggerforandroid.component.application

import android.app.Application
import com.example.daggerforandroid.BaseApplication
import com.example.daggerforandroid.module.ActivityBuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
     modules = [
                AndroidInjectionModule::class,
                ActivityBuildersModule::class,
                 AppModule::class]
)
interface AppComponent:AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        fun build(): AppComponent

        @BindsInstance
        fun application(appComponent:Application): Builder
    }
}