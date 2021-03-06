package com.ardev.testecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ardev.testecommerce.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun layoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun onBackPressed() {
        val currentFragment = getCurrentFragment()
        if (null != currentFragment && currentFragment.isOverrideOnBackPress()) {
            currentFragment.onBackPress()
        } else {
            super.onBackPressed()
        }
    }

}