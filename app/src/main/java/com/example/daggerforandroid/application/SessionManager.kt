package com.example.daggerforandroid.application

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.User
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {


    var catchedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateUser(source : LiveData<AuthResource<User>>){

        if(catchedUser != null ){
            catchedUser.value= AuthResource.loading(null)
            Log.e("Value set to ", Gson().toJson(catchedUser.value))
            catchedUser.addSource(source,object : Observer<AuthResource<User>>{
                override fun onChanged(t: AuthResource<User>?) {
                    catchedUser.value=t
                    catchedUser.removeSource(source)
                }
            })
        }
    }

    fun logout (){

        catchedUser.value = (AuthResource.logout())

    }

    fun getAuthUser():LiveData<AuthResource<User>>{
        return  catchedUser
    }


}