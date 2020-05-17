package com.example.daggerforandroid.mainApp.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.mainApp.auth.model.Resource
import com.example.daggerforandroid.mainApp.home.model.Post
import com.example.daggerforandroid.mainApp.home.model.Resource
import com.example.daggerforandroid.mainApp.home.service.PostApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.net.ResponseCache
import java.util.ArrayList
import javax.inject.Inject

class PostViewModel @Inject constructor(val sessionManager: SessionManager,val postApi: PostApi): ViewModel() {

    init {
        Log.i("Init the postViewModel", "PostViewModel")
    }

     lateinit var mutebleLiveData : MutableLiveData<Resource<Post>>

    fun getPost():Resource<List<Post>>{

        LiveDataReactiveStreams.fromPublisher(
        postApi.getPostsFromUser(sessionManager.getAuthUser().value!!.data!!.id)
            .onErrorReturn( object :Function<Throwable, List<Post>>{
                override fun apply(t: Throwable): List<Post> {
                    var post = Post()
                    post.id=-1
                    var allPosts = ArrayList<Post>()

                    allPosts.add(post)

                    return allPosts
                }
            })
            .map( object  : Function<  List<Post?>?, Resource<List<Post>?>>{
                override fun apply(post: List<Post?>): Resource<List<Post>?> {
                    if(post[0]!!.userId == -1){

                        return  Resource.error("An error Occured",null )
                    }
                    return Resource.success()
                }

            }  )
               .subscribeOn(Schedulers.io())
        )
    }
}

