package com.example.daggerforandroid.component.application

import dagger.Module
import dagger.Provides

/**
 * This Module Takes charge of the dependency that will be required to be instantiated once throughout the livecycle of the application
 *Also meant for instantiating dependencies apart from that are not Activities
  **/

@Module
class AppModule {


//    companion object {
//        @JvmStatic
        @Provides
        fun getValue(): String {
            return "Dummy Value for Verifying All is well "
        }

//    }
}