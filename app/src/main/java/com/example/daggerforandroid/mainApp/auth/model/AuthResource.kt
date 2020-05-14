package com.example.daggerforandroid.mainApp.auth.model

class AuthResource<out T>(val status: AuthStatus,
    val data: T?,
    val message: String? ) {


    companion object {
        fun <T> authenticated(data: T?): AuthResource<T> {
            return AuthResource(
                AuthStatus.AUTHENTICATED,
                data,
                null
            )
        }

        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(
                AuthStatus.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data: T?): AuthResource<T>{
            return AuthResource(
                AuthStatus.LOADING,
                data,
                null
            )
        }

        fun <T> logout(): AuthResource<T> {
            return AuthResource(
                AuthStatus.NOT_AUTHENTICATED,
                null,
                null
            )
        }
    }

}


//ALSO EXPLORE USING THIS


// A generic class that contains data and status about loading this data.
//sealed class Resource<T>(
//    val data: T? = null,
//    val message: String? = null
//) {
//    class Success<T>(data: T) : Resource<T>(data)
//    class Loading<T>(data: T? = null) : Resource<T>(data)
//    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
//}