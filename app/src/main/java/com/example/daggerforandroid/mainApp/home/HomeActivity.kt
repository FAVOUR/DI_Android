package com.example.daggerforandroid.mainApp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerforandroid.R
import com.example.daggerforandroid.mainApp.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Toast.makeText(this,"Welcome to this App",Toast.LENGTH_SHORT).show()
    }
}
