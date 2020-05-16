package com.example.daggerforandroid.mainApp.home.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.mainApp.auth.model.AuthResource
import com.example.daggerforandroid.mainApp.auth.model.User
import com.example.daggerforandroid.mainApp.home.di.module.PostApiModule
import com.example.daggerforandroid.mainApp.home.service.PostApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(val sessionManager: SessionManager,val postApi: PostApi): ViewModel() {

    init {
        Log.i("Init the postViewModel", "PostViewModel")
    }

//
//    fun getPost(id:Int):AuthResource<User>{
//
//        postApi.getPostsFromUser(id)
//            .subscribeOn(Schedulers.io())
//
//    }
}