package com.example.daggerforandroid.application.di.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import kotlin.reflect.KClass


@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey

internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

//annotation class  ViewModelKey {
//
//    class value():< KClass<out ViewModel>
//
//}
