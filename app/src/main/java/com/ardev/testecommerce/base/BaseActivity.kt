package com.ardev.secondcourseapplication.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import java.util.*

abstract class BaseActivity: AppCompatActivity() {

    var mLocale: Locale? = null

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(layoutId())
//        (application as AndroidApplication).appComponent.inject(this)

    }

    private fun getCurrentFragment(): BaseFragment? {
        val fragments = supportFragmentManager.fragments
        if (!fragments.isNullOrEmpty()) {
            for (fragment in fragments) {
                if (null != fragment && fragment is NavHostFragment) {
                    val currentFragment = getLatestFragment(fragment.childFragmentManager.fragments)
                    if (null != currentFragment && currentFragment is BaseFragment) {
                        return currentFragment
                    }
                }
            }
        }

        return null
    }

    private fun getLatestFragment(fragments: List<Fragment>): Fragment?{
        if (fragments.isNotEmpty()){
            return fragments[fragments.size - 1]
        }
        return null
    }

}