package com.example.daggerforandroid.mainApp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.daggerforandroid.R
import com.example.daggerforandroid.mainApp.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Toast.makeText(this,"Welcome to this App",Toast.LENGTH_SHORT).show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater

        menuInflater.inflate(R.menu.home_activity_menu,menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when(item.itemId){
             R.id.logout ->{
                 sessionManager.logout()
             }
         }
        return super.onOptionsItemSelected(item)
    }
}
