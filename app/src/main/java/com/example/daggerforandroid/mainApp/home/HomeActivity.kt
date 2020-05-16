package com.example.daggerforandroid.mainApp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.daggerforandroid.R
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.mainApp.BaseActivity
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.AuthStatus
import com.example.daggerforandroid.mainApp.auth.model.User
import com.example.daggerforandroid.mainApp.home.fragment.PostFragment
import com.example.daggerforandroid.mainApp.home.fragment.ProfileFragment
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

     Toast.makeText(this,"Welcome to this App",Toast.LENGTH_SHORT).show()

        setupFragment()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater

        menuInflater.inflate(R.menu.home_activity_menu,menu)

        return true
    }


     fun setupFragment(){
         var fragment = supportFragmentManager.beginTransaction()
                                             .replace(R.id.fragment_container,PostFragment())
                                             .commit()
     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when(item.itemId){
             R.id.logout ->{

                 sessionManager.logout()
                 return true
             }
             else -> return super.onOptionsItemSelected(item)

         }
    }
}
