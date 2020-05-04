package com.example.daggerforandroid.component.application

import android.app.Application
import com.example.daggerforandroid.BaseApplication
import com.example.daggerforandroid.module.ActivityBuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
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


        //Causes the instance of App component Application tp be available to every module attached to in this component
        @BindsInstance
        fun application(appComponent:Application): Builder
    }
}