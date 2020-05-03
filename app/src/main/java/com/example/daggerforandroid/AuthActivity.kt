package com.example.daggerforandroid
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity()  {


    var TAG = "AuthActivity"

    @Inject
   lateinit var yolo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        Log.i(TAG, yolo )
    }
}
