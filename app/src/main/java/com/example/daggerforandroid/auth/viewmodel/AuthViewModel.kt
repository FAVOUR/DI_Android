package com.example.daggerforandroid.auth.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerforandroid.auth.model.User
import com.example.daggerforandroid.auth.services.AuthApi
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

 class  AuthViewModel  @Inject constructor(auth:AuthApi): ViewModel() {

  init {
      Log.d("ViewModel","ViewModel is Working ")

      if(auth !=null) {
          Log.d("ViewModel", "AuthApi has been instantiated")
          auth.getUser(1)
              .toObservable()
              .subscribeOn(Schedulers.io())
//              .observeOn(AndroidSchedulers.mainThread())
              .subscribe { object :  Observer<User>{
                  override fun onComplete() {

                  }

                  override fun onSubscribe(d: Disposable) {
                  }

                  override fun onNext(t: User) {
                      Log.i("User",Gson().toJson(t))
                  }

                  override fun onError(e: Throwable) {
                      Log.e("onError",Gson().toJson(e))

                  }
              } }
      }
      else {
          Log.d("ViewModel", "AuthApi is not instantiated")
      }


  }



}
