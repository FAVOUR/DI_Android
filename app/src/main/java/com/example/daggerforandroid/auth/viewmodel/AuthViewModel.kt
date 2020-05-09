package com.example.daggerforandroid.auth.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.auth.netwotk.AuthApi
import javax.inject.Inject

 class  AuthViewModel  @Inject constructor(auth:AuthApi): ViewModel() {

  init {
      Log.d("ViewModel","ViewModel is Working ")

      if(auth !=null)
          Log.d("ViewModel","AuthApi has been instantiated")
      else
          Log.d("ViewModel","AuthApi is not instantiated")


  }



}
