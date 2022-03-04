
package com.ardev.testecommerce.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.ardev.testecommerce.R

abstract class BaseFragment: Fragment() {

    private var mView: View? = null

    fun getmView(): View? {
        return mView
    }

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDagger()
        initializeData()
        initializeViewModel()

        trackScreen()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (null == mView) {
            mView = inflater.inflate(layoutId(), container, false)
        }
        return mView!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        registerEvent()
        executeData()
    }

    internal fun navigate(
        graphId: Int,
        singleTop: Boolean = false,
        args: Bundle? = null,
        popupTo: Int? = null
    ) {
        val builder = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .setLaunchSingleTop(singleTop)
        if (null != popupTo) {
            builder.setPopUpTo(popupTo, true)
        }

        try {
            val options = builder.build()
            findNavController().navigate(graphId, args, options)
        } catch (e: Exception) {
            Log.e("navigate", "${e.message}")
        }
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