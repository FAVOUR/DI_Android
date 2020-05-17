package com.example.daggerforandroid.mainApp.home.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerforandroid.R
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import com.example.daggerforandroid.mainApp.home.model.Post
import com.example.daggerforandroid.mainApp.home.model.Resource
import com.example.daggerforandroid.mainApp.home.recyclerview.PostsRecyclerAdapter
import com.example.daggerforandroid.mainApp.home.viewmodel.PostViewModel
import com.google.gson.Gson
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory
    lateinit var  postViewModel: PostViewModel

    @Inject
    lateinit var postsRecyclerAdapter: PostsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        postViewModel= ViewModelProviders.of(this,viewmodelProviderFactory)[PostViewModel::class.java]
        setuprecyclerView()
        subScribeToObserver()
    }


    fun setuprecyclerView (){
        recycler_view.adapter =postsRecyclerAdapter
        var layoutManager =LinearLayoutManager(activity)
        recycler_view.layoutManager=layoutManager
        var itemDecorator = DividerItemDecoration(recycler_view.context,layoutManager.orientation)
        recycler_view.addItemDecoration(itemDecorator)
    }

     fun subScribeToObserver(){
         postViewModel.getPost().removeObservers(viewLifecycleOwner)

         postViewModel.getPost().observe(this, object :Observer<Resource<List<Post?>>>{
             override fun onChanged(t: Resource<List<Post?>>) {

                 Log.e("the Post data gotten ", Gson().toJson(t))
                 if(t != null) {
                     when (t.status) {

                         Resource.Status.LOADING -> {
                             Log.e("the Post data Loading  ",".........")

                         }

                         Resource.Status.SUCCESS -> {
                             postsRecyclerAdapter.setPosts(t.data)
                         }

                         Resource.Status.ERROR -> {
                             Log.e("the Post data Error ", Gson().toJson(t))

                         }
                     }

                 }
             }
         })

     }
}