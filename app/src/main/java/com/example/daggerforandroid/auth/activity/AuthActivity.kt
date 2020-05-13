package com.example.daggerforandroid.auth.activity
import android.app.ProgressDialog
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.daggerforandroid.R
import com.example.daggerforandroid.auth.viewmodel.AuthViewModel
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import com.example.daggerforandroid.auth.model.AuthResource
import com.example.daggerforandroid.auth.model.AuthStatus
import com.example.daggerforandroid.auth.model.User
import com.google.gson.Gson
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


        authViewModel.observeUser()?.observe(this, object : Observer<AuthResource<User>> {
            override fun onChanged(t: AuthResource<User>) {
                Log.e("Throwable", Gson().toJson(t))

                  when(t.status){

                      AuthStatus.AUTHENTICATED->{
                          showProgressBar(showProgressBar = false)
                          Toast.makeText(this@AuthActivity,t.message,Toast.LENGTH_SHORT).show()

                      }
                      AuthStatus.ERROR->{
                          showProgressBar(showProgressBar = false)
                          Toast.makeText(this@AuthActivity,t.message,Toast.LENGTH_SHORT).show()

                      }
                  AuthStatus.LOADING->{
                       showProgressBar(showProgressBar = true)

                  }
                      AuthStatus.NOT_AUTHENTICATED->{
                          showProgressBar(showProgressBar = false)
                          Toast.makeText(this@AuthActivity,t.message,Toast.LENGTH_SHORT).show()


                      }
                  }
//                Toast.makeText(this@AuthActivity,"User with user name  ${t!!.} logged in ", Toast.LENGTH_SHORT).show()


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


    fun showProgressBar(showProgressBar:Boolean){
        if(showProgressBar){
            progress_bar.visibility=View.VISIBLE
        }else{
            progress_bar.visibility=View.GONE

        }
    }
}
