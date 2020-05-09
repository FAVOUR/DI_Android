package com.example.daggerforandroid.auth.activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.daggerforandroid.R
import com.example.daggerforandroid.auth.viewmodel.AuthViewModel
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.auth_activity.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity()  {


    var TAG = "AuthActivity"

    @Inject
   lateinit var yolo:String

    @Inject
    lateinit var requestManager: RequestManager


    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var providerFactory :ViewModelProviderFactory

    lateinit var authViewModel:AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
        authViewModel= ViewModelProviders.of(this,providerFactory).get(AuthViewModel::class.java)
        Log.i(TAG, yolo )

     setImage()


    }

    fun setImage(){
        requestManager
            .load(logo)
            .into(login_logo)
    }
}
