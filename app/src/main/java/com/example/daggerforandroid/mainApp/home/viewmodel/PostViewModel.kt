package com.example.daggerforandroid.mainApp.home.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.mainApp.home.model.Post
import com.example.daggerforandroid.mainApp.home.model.Resource
import com.example.daggerforandroid.mainApp.home.service.PostApi
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.net.ResponseCache
import java.util.ArrayList
import javax.inject.Inject

class PostViewModel @Inject constructor(private val sessionManager: SessionManager,private val postApi: PostApi): ViewModel() {

    init {
        Log.i("Init the postViewModel", "PostViewModel")
    }

     private lateinit var mediatorLiveData : MediatorLiveData<Resource<List<Post?>>>

    fun getPost():LiveData<Resource<List<Post?>>> {
        if (mediatorLiveData == null) {
            mediatorLiveData = MediatorLiveData()
            mediatorLiveData.value =Resource.loading(null)

            var response : Flowable<Resource<List<Post?>>> =

                        postApi . getPostsFromUser (sessionManager.getAuthUser().value!!.data!!.id)
                    .onErrorReturn(object : Function<Throwable, List<Post>> {
                        override fun apply(t: Throwable): List<Post> {
                            var post = Post()
                            post.id = -1
                            var allPosts = ArrayList<Post>()

                            allPosts.add(post)

                            return allPosts
                        }
                    })

                            .map(object : Function<List<Post?>?, Resource<List<Post?>>> {  //Means post can be empty and the
                        //                the list can also be empty
                        override fun apply(post: List<Post?>): Resource<List<Post?>>{
                            var  firstPost :Int =post[0]?.userId ?: -1
                            if (firstPost == -1) {

                                return Resource.error("An error Occurred", null)
                            }
                            return Resource.success(post)
                        }

                    })
                      .subscribeOn(Schedulers.io())


            var source: LiveData<Resource<List<Post?>>> = LiveDataReactiveStreams.fromPublisher(response)
            mediatorLiveData.addSource(source, object : Observer<Resource<List<Post?>>> {
                    override fun onChanged(t: Resource<List<Post?>>) {
                        mediatorLiveData.value= t
                        mediatorLiveData.removeSource(source)
                    }
                })

        }
       return mediatorLiveData
    }
}

