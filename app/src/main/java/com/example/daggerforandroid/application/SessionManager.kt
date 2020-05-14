package com.example.daggerforandroid.application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.daggerforandroid.auth.activity.AuthActivity
import com.example.daggerforandroid.auth.model.AuthResource
import com.example.daggerforandroid.auth.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {


    var catchedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateUser(source : LiveData<AuthResource<User>>){
        if(catchedUser != null ){
            catchedUser.value= AuthResource.loading(null)

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

    fun catchedUser():LiveData<AuthResource<User>>{
        return  catchedUser
    }


}