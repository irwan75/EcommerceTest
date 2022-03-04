package com.ardev.testecommerce.base

import android.app.Application
import android.content.Context
//import com.ardev.secondcourseapplication.di.ApplicationComponent

class AndroidApplication : Application(){

//    private var context: Context? = null
//    public fun getContext():Context?{
//        return context
//    }

    companion object{

    }

//    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
//        DaggerApplicationComponent
//            .builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()
//        context = applicationContext
    }



}