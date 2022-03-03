package com.ardev.secondcourseapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDagger()
        initializeData()
        initializeViewModel()

        trackScreen()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        registerEvent()
        executeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregister()
    }

    open fun injectDagger() {
        //inject dagger
    }

    open fun initializeData() {
        //parse data
    }

    open fun initializeViewModel() {
        //init view model
    }

    open fun setupView() {
        //setup views
    }

    open fun registerEvent() {
        //setup events
    }

    open fun executeData() {
        //setup data
    }

    private fun trackScreen() {
        //function to send track analytics
    }

    open fun unregister() {
        //unregister events
    }

}