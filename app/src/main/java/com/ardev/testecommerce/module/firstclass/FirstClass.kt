package com.ardev.secondcourseapplication

import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.ardev.secondcourseapplication.base.BaseFragment

class FirstClass : BaseFragment(){
    override fun layoutId()=R.layout.fragment_first_class

    override fun setupView() {
        super.setupView()
        val btnPrevious = view?.findViewById<Button>(R.id.btnToPreviousFirstClass)
        btnPrevious?.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

}