package com.example.daggerforandroid.auth.activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.daggerforandroid.R
import com.example.daggerforandroid.auth.viewmodel.AuthViewModel
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import com.example.daggerforandroid.auth.model.User
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
//        authViewModel.getUser()


        login_button.setOnClickListener {
                       if(!(TextUtils.isEmpty(user_id_input.text.toString()) )) {
                                 attemptLogin(user_id_input.text.toString())
                           }else{

                           Toast.makeText(this,"Please Input your Id", Toast.LENGTH_SHORT).show()
                       }
        }


        authViewModel.observeUser().observe(this, object : Observer<User> {
            override fun onChanged(t: User?) {
                Toast.makeText(this@AuthActivity,"User with user name  ${t!!.username} logged in ", Toast.LENGTH_SHORT).show()


            }
        })



    }

    private fun attemptLogin(userInput: String) {
        authViewModel.authenticateWithUserId(userInput.toInt())
    }

    fun setImage(){
        requestManager
            .load(logo)
            .into(login_logo)
    }
}
