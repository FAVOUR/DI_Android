package com.example.daggerforandroid.auth.viewmodel

import androidx.lifecycle.*
import com.example.daggerforandroid.application.SessionManager
import com.example.daggerforandroid.auth.model.AuthResource
import com.example.daggerforandroid.auth.model.User
import com.example.daggerforandroid.auth.services.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

 class  AuthViewModel  @Inject constructor( val auth:AuthApi, val sessionManager:SessionManager) : ViewModel() {

//      Log.d("ViewModel","ViewModel is Working ")

     var authUser : MediatorLiveData<AuthResource<User>> = MediatorLiveData()
//     var authUser : MutableLiveData<User> = MutableLiveData()

       fun authenticateWithUserId(id:Int){
           sessionManager.authenticateUser(querywithUserId(id))
       }

     fun querywithUserId(userid:Int):LiveData<AuthResource<User>>{
         val data = auth.getUser(userid)
             .onErrorReturn(object :Function<Throwable,User>{
                 override fun apply(t: Throwable): User {
                     var user = User()
                     user.id=-1
                     return  user
                 }

             })
             .subscribeOn(Schedulers.io())
             .map(object  : Function<User,AuthResource<User>>{
                 override fun apply(user: User): AuthResource<User> {
                     if(user.id == -1){
                         return  AuthResource.error("An Error Occured",null)
                     }else{
                         return  AuthResource.authenticated(user)

                     }
                 }
             })

         val source = LiveDataReactiveStreams.fromPublisher(data)

         return  source

     }

     fun observeAuthState() :LiveData<AuthResource<User>>?{
         return  sessionManager.catchedUser()
     }

/*
      if(auth !=null) {*/
//          Log.d("ViewModel", "AuthApi has been instantiated")

//         auth.getUser(1)
//             .toObservable()
//             .subscribeOn(Schedulers.io())
//



//          getUser(auth)

     /* }
      else {
          Log.d("ViewModel", "AuthApi is not instantiated")
      }*/




/*
         fun getUser(auth:AuthApi){
             try {

                 auth.getUser(1)
                     .toObservable()
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe {
                         object : Observer<User> {
                             override fun onComplete() {
                                 Log.i("onComplete", "Done")

                             }

                             override fun onSubscribe(d: Disposable) {
                             }

                             override fun onNext(t: User) {
                                 Log.i("User", Gson().toJson(t))
                             }

                             override fun onError(e: Throwable) {
                                 Log.e("onError", Gson().toJson(e))

                             }
                         }
                     }
             }catch (e:Throwable){
                 Log.e("Throwable", Gson().toJson(e))

             }
         }
*/






}
