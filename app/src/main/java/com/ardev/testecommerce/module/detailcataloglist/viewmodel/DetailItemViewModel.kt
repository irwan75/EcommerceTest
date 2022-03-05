package com.ardev.testecommerce.module.detailcataloglist.viewmodel

import androidx.lifecycle.ViewModel
import com.ardev.testecommerce.base.BaseViewModel

class DetailItemViewModel : BaseViewModel() {

    private var valueTemporary: Int = 0
    fun getValueTemporary(): Int{
        return valueTemporary
    }

    fun incrementValue(){
        this.valueTemporary++
    }

}