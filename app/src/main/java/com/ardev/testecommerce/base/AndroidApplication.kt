package com.ardev.secondcourseapplication.base

import android.app.Application
import android.content.Context
import com.ardev.secondcourseapplication.di.ApplicationComponent

class AndroidApplication : Application(){

    companion object{
        var context: Context? = null
    }

//    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
//        DaggerApplicationComponent
//            .builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }



}