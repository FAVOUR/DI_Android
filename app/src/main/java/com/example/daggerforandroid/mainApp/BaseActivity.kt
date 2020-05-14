package com.example.daggerforandroid.mainApp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.AuthStatus
import com.example.daggerforandroid.mainApp.auth.model.User
import com.google.gson.Gson
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

 open class BaseActivity :DaggerAppCompatActivity() {


    @Inject
   lateinit var sessionManager :SessionManager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        subscribeObserver()


    }

    fun subscribeObserver(){
        sessionManager.getAuthUser().observe(this, Observer<AuthResource<User>> {it ->
            Log.e("current state", Gson().toJson(it))

            when(it.status){

                AuthStatus.AUTHENTICATED->{
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()

                }
                AuthStatus.ERROR->{

                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
                    logout()

                }
                AuthStatus.LOADING->{

                }
                AuthStatus.NOT_AUTHENTICATED->{
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()

                    logout()


                }
            }
        })
    }

         fun logout(){
             var intent = Intent(this ,AuthActivity::class.java)
             startActivity(intent)
         }

}