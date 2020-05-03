package com.example.daggerforandroid
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class AuthActivity : DaggerAppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
    }
}
