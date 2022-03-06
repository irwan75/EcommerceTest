package com.ardev.testecommerce.repository

import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.services.cloud.NetworkInstance
import com.ardev.testecommerce.shared.exception.Failure
import com.ardev.testecommerce.shared.helper.Either

class ItemsRepository {

//    fun getDataItems(): Either<Failure, Boolean>
//
//    fun saveDataItems(): Either<Failure, Boolean>

    suspend fun getItemsData(): List<ResponseItemsData>?{
        val request = NetworkInstance.clientItems.getItemsData()

        if(request.isSuccessful){
            return request.body
        }

        return listOf<ResponseItemsData>()
    }

}