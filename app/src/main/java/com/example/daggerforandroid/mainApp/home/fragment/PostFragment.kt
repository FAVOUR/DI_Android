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
import com.example.daggerforandroid.R
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.application.di.viewmodels.ViewModelProviderFactory
import com.example.daggerforandroid.mainApp.home.model.Post
import com.example.daggerforandroid.mainApp.home.model.Resource
import com.example.daggerforandroid.mainApp.home.viewmodel.PostViewModel
import com.google.gson.Gson
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory
    lateinit var  postViewModel: PostViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        postViewModel= ViewModelProviders.of(this,viewmodelProviderFactory)[PostViewModel::class.java]

        subScribeToObserver()
    }

     fun subScribeToObserver(){
//         postViewModel.getPost().removeObservers(viewLifecycleOwner)

         postViewModel.getPost().observe(this, object :Observer<Resource<List<Post?>>>{
             override fun onChanged(t: Resource<List<Post?>>) {

                 Log.e("the Post date gotten ", Gson().toJson(t))
             }
         })

     }
}