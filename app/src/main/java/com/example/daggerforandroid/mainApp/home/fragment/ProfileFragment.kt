package com.example.daggerforandroid.mainApp.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.daggerforandroid.R
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.AuthStatus
import com.example.daggerforandroid.mainApp.auth.model.User
import com.example.daggerforandroid.mainApp.home.viewmodel.ProfileViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelProfile: ViewModelProviderFactory
    lateinit var profileViewModel:ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        Log.i("Fragment setup", true.toString())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileViewModel = ViewModelProviders.of(this,viewModelProfile)[ProfileViewModel::class.java]

        setAuthentication()
    }

      private fun setAuthentication(){
          profileViewModel.getAuthUser().removeObservers(viewLifecycleOwner)
          profileViewModel.getAuthUser().observe(this, Observer {it ->
                when(it.status){

                    AuthStatus.AUTHENTICATED ->{
                        setAuthUserDetails(it.data!!)
                    }
                    AuthStatus.ERROR ->{
                        setUnAuthenticatedUserDetails(it.message!!)

                    }
                }
          })
      }


    fun setAuthUserDetails(user: User){
        username.text=user.username
        email.text=user.email
        website.text=user.website
    }

    fun setUnAuthenticatedUserDetails(message:String){
        username.text= message
        email.text="Error"
        website.text="Error"
    }


}
