package com.example.daggerforandroid.auth.viewmodel

import androidx.lifecycle.*
import com.example.daggerforandroid.auth.model.AuthResource
import com.example.daggerforandroid.auth.model.User
import com.example.daggerforandroid.auth.services.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

 class  AuthViewModel  @Inject constructor( val auth:AuthApi) : ViewModel() {

//      Log.d("ViewModel","ViewModel is Working ")

     var authUser : MediatorLiveData<AuthResource<User>> = MediatorLiveData()
//     var authUser : MutableLiveData<User> = MutableLiveData()

       fun authenticateWithUserId(id:Int){
          val data = auth.getUser(id)
              .onErrorReturn(object :Function<Throwable,User>{
                  override fun apply(t: Throwable): User {
                      var user = User()
                       user.id=1
                      return  user
                  }

              })
                                     .subscribeOn(Schedulers.io())
              .map(object  : Function<User,AuthResource<User>>{
                  override fun apply(t: User): AuthResource<User> {
                      if(t.id == -1){
                          return  AuthResource.error("An Error Occured",null)
                      }
                  }
              })

           val source = LiveDataReactiveStreams.fromPublisher(data)

           authUser.addSource(source , object : Observer<User> {
               override fun onChanged(t: User?) {
                   authUser.value=AuthResource.loading(null as User)
//                   authUser.value=t
                   authUser.removeSource(source)
               }
           })
       }

     fun observeUser() :LiveData<AuthResource<User>>?{
         return  authUser
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
