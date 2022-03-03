package com.ardev.secondcourseapplication.base

import android.location.Location

class ApplicationSharing {

    private var name: String = ""
    private var address: String = ""
    private var number: Int = 0

    fun getName(): String {
        return name
    }

    fun setName(valueName: String){
        this.name = valueName
    }

    fun getAddress(): String {
        return address
    }

    fun setAddress(valueAddress: String){
        this.address = valueAddress
    }

    fun getNumber(): Int {
        return number
    }

    fun setNumber(valueNumber: Int){
        this.number = valueNumber
    }


}