package com.example.daggerforandroid.mainApp

import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.DaggerActivity

class BaseActivity :DaggerActivity() {



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }
}