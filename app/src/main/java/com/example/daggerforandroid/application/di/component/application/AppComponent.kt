package com.example.daggerforandroid.application.di.component.application

import android.app.Application
import com.example.daggerforandroid.application.BaseApplication
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.application.di.module.activity.ActivityBuildersModule
import com.example.daggerforandroid.application.di.module.application.AppModule
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
/*         ,
                 ViewModelFactoryModule::class]*/
)
interface AppComponent:AndroidInjector<BaseApplication> {

    fun sessionManager () : SessionManager

    @Component.Builder
    interface Builder{
        fun build(): AppComponent


        //Causes the instance of App component Application tp be available to every module attached to in this component
        @BindsInstance
        fun application(appComponent:Application): Builder
    }
}