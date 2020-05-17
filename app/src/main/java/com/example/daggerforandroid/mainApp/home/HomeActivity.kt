package com.example.daggerforandroid.mainApp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.navigation.*
import androidx.navigation.ui.NavigationUI
import com.example.daggerforandroid.R
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.mainApp.BaseActivity
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.AuthStatus
import com.example.daggerforandroid.mainApp.auth.model.User
import com.example.daggerforandroid.mainApp.home.fragment.PostFragment
import com.example.daggerforandroid.mainApp.home.fragment.ProfileFragment
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(),NavigationView.OnNavigationItemSelectedListener {

   lateinit var  navController: NavController


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
       navController = Navigation.findNavController(this ,R.id.nav_host_fragment)

         NavigationUI.setupWithNavController(nav_view,navController)
         NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)  //adding the drawerLayout makes the hamburger  icon appear
//         NavigationUI.navigateUp(navController,drawer_layout)
         nav_view.setNavigationItemSelectedListener(this)

     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when(item.itemId){
             R.id.logout ->{

                 sessionManager.logout()
                 return true
             }
             android.R.id.home ->{
                 return if(drawer_layout.isDrawerOpen(GravityCompat.START)){
                     drawer_layout.closeDrawer(GravityCompat.START)
                     true
                 }else{
                     false
                 }
             }
             else -> return super.onOptionsItemSelected(item)

         }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){


            R.id.profile ->{
                var  controller = NavOptions.Builder()
                    .setPopUpTo(R.id.nav_fragment,true)
                    .build()

                navController.navigate(R.id.nav_profile_fragment,null,controller)
            }

            R.id.post ->{
                if(isDestinationPreviouslyOpened(R.id.nav_post_fragment)){
                    navController.navigate(R.id.nav_post_fragment)

                }

            }
        }
        item.isChecked = true //Heights  the text that it has been clicked
        drawer_layout.closeDrawer(GravityCompat.START)
        return false
    }

    fun  isDestinationPreviouslyOpened(destination :Int):Boolean{
         return   destination != navController.currentDestination!!.id
    }

    override fun onSupportNavigateUp(): Boolean {
        NavigationUI.navigateUp(navController,drawer_layout)
        return true
    }
}
