package com.example.daggerforandroid.application.di.module.application

import android.app.Application
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerforandroid.R
import com.example.daggerforandroid.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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

    @Singleton
    @JvmStatic
    @Provides
    fun provideRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

    }


    @Singleton
    @JvmStatic
    @Provides
    fun  client(){
        var client:OkHttpClient.Builder=OkHttpClient.Builder()
            .addInterceptor()

    }


    @Singleton
    @JvmStatic
    @Provides
    fun  LoggerInterceptor(){
        var loggerr=
            .addInterceptor()
    }



}



}