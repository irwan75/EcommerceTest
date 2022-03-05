package com.ardev.testecommerce.services.cloud.api

import com.ardev.testecommerce.models.others.Items
import retrofit2.Call
import retrofit2.http.GET

internal interface ApiItems {

    companion object{
        private const val SLIDE = "/rest/store_view/V1/homepage/getSlider"
        private const val POST_LIST = "/rest/store_view/V1/blog/getPost"
    }

    @GET(SLIDE)
    fun getItemsData(
//        @Query(PARAM_PAGE_SIZE) pageSize: Int,
//        @Query(PARAM_PAGE_NUMBER) pageNumber: Int
    ): Call<Items>

}