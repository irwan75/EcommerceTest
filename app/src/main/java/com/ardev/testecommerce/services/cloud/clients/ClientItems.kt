package com.ardev.testecommerce.services.cloud.clients

import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.models.response.SimpleResponse
import com.ardev.testecommerce.services.cloud.api.ApiItems
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class ClientItems(private val apiItems: ApiItems)  {

    suspend fun getItemsData(): SimpleResponse<List<ResponseItemsData>>{
        return safeApiCall { apiItems.getItemsData() }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}