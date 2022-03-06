package com.ardev.testecommerce.base

import android.app.Application
import android.content.Context

class AndroidApplication : Application(){

    companion object{
        lateinit var context: Context
    }

//    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
//        DaggerApplicationComponent
//            .builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }



}