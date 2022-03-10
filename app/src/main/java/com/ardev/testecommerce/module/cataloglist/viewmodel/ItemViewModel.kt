package com.ardev.testecommerce.module.cataloglist.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ardev.testecommerce.base.BaseViewModel
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.repository.ItemsRepository
import com.ardev.testecommerce.services.cache.DbHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor (private val itemsRepository: ItemsRepository)  : BaseViewModel() {

    private val _getItemsData = MutableLiveData<List<ResponseItemsData>?>()
    val getItemsData: LiveData<List<ResponseItemsData>?> = _getItemsData
//
    fun fetchDataItem()=
        viewModelScope.launch {
            val response = itemsRepository.getItemsData()

            _getItemsData.postValue(response)
        }


}