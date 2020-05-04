package com.example.daggerforandroid.component.application

import android.app.Application
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerforandroid.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This Module Takes charge of the dependency that will be required to be instantiated once throughout the livecycle of the application
 *Also meant for instantiating dependencies apart from that are not Activities
  **/

@Module
class AppModule {


@Module
    companion object {

    @Singleton
    @JvmStatic
        @Provides
        fun getValue(): String {
            return "Dummy Value for Verifying All is well "
        }

    @Singleton
    @JvmStatic
    @Provides
    fun  providesRequestOptions():RequestOptions{
        return RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun providesRequestOptionsManager(application:Application,requestOptions:RequestOptions):RequestManager{
              return Glide.with(application)
                  .setDefaultRequestOptions(requestOptions)
    }


    @Singleton
    @JvmStatic
    @Provides
        fun providesDrawable(application:Application):Drawable{
       return  application.applicationContext.resources.getDrawable(R.drawable.logo)
    }





}



}