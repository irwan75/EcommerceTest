package com.ardev.testecommerce.module.detailcataloglist.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardev.testecommerce.base.BaseViewModel
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.repository.ItemsRepository
import com.ardev.testecommerce.services.cache.DbHelper
import dagger.hilt.android.lifecycle.HiltViewModel
//import com.ardev.testecommerce.services.cache.DbHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailItemViewModel @Inject constructor(private val itemsRepository: ItemsRepository)  : BaseViewModel() {

    private val _getItem = MutableLiveData<Items>()
    val getItem: LiveData<Items> = _getItem

    fun saveDataItem(item: Items) {
        viewModelScope.launch {
            itemsRepository.saveItemsCache(item)
        }
    }

    fun deleteItem(item: Items) {
        viewModelScope.launch {
            itemsRepository.deleteItem(item)
        }
    }

    fun updateItemById(id: Int, item: Items) {
        viewModelScope.launch {
            item.content?.let { itemsRepository.updateItemById(id, it) }
        }
    }

    fun fetchItem(id: Int)=
        viewModelScope.launch {
            val response = itemsRepository.getItem(id)

            _getItem.postValue(response)
        }

    private var valueTemporary: Int = 0
    fun getValueTemporary(): Int{
        return valueTemporary
    }

    fun incrementValue(){
        this.valueTemporary++
    }

}