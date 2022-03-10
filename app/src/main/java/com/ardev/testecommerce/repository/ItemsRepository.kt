package com.ardev.testecommerce.repository

import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.services.cache.dao.items.DaoItems
import com.ardev.testecommerce.services.cloud.NetworkInstance
import javax.inject.Inject

class ItemsRepository @Inject constructor (private val daoItems: DaoItems)  {

//    fun getDataItems(): Either<Failure, Boolean>
//
//    fun saveDataItems(): Either<Failure, Boolean>

    suspend fun saveItemsCache(items: Items) {
        daoItems.saveItem(items)
    }

    suspend fun getItem(id: Int): Items{
        return daoItems.getItemById(id)
    }

    suspend fun deleteItem(items: Items){
        daoItems.deleteItem(items)
    }

    suspend fun updateItemById(id: Int, content:String){
        return daoItems.updateItemById(id, content)
    }

    suspend fun getItemsData(): List<ResponseItemsData>?{
        val request = NetworkInstance.clientItems.getItemsData()

        if(request.isSuccessful){
            return request.body
        }

        return listOf<ResponseItemsData>()
    }

}