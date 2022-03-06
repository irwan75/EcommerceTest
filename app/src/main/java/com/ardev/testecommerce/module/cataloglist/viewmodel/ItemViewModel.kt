package com.ardev.testecommerce.module.cataloglist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ardev.testecommerce.base.BaseViewModel
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.repository.ItemsRepository
import kotlinx.coroutines.launch

class ItemViewModel : BaseViewModel() {

    private val itemsRepository = ItemsRepository()

    private val _getItemsData = MutableLiveData<List<ResponseItemsData>>()
    val getItemsData: LiveData<List<ResponseItemsData>> = _getItemsData

    fun fetchDataItem()=
        viewModelScope.launch {
            val response = itemsRepository.getItemsData()

            _getItemsData.postValue(response)
        }


}