package com.ardev.secondcourseapplication

import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ardev.secondcourseapplication.base.BaseFragment

class SecondClass: BaseFragment() {
    override fun layoutId()=R.layout.fragment_second_class

    override fun setupView() {
        super.setupView()
        val btnPrevious = view?.findViewById<Button>(R.id.btnToPreviousFirstClass)
        btnPrevious?.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

}