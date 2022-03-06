package com.ardev.testecommerce.services.cloud.api

import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.models.response.SimpleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiItems {

    companion object{
        private const val SLIDE = "/rest/store_view/V1/homepage/getSlider"
        private const val POST_LIST = "posts"
    }

    @GET(POST_LIST)
    suspend fun getItemsData(
//        @Query(PARAM_PAGE_SIZE) pageSize: Int,
//        @Query(PARAM_PAGE_NUMBER) pageNumber: Int
    ): Response<List<ResponseItemsData>>

}