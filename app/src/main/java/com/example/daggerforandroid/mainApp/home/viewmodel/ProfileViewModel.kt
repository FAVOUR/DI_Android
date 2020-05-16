package com.example.daggerforandroid.mainApp.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.User
import javax.inject.Inject

class ProfileViewModel @Inject constructor(val sessionManager: SessionManager): ViewModel(){

    init {
        Log.i("Profileviewmodel"," is working.... ")
    }

    fun getAuthUser(): LiveData<AuthResource<User>> {
       return  sessionManager.getAuthUser()
    }
}