package com.ardev.testecommerce.services.cloud.service

import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.services.cloud.api.ApiItems
import retrofit2.Call
import retrofit2.Retrofit

class ServiceItems constructor(private var retrofit: Retrofit): ApiItems {

//    private val campaignApi by lazy { retrofit.create(CampaignApi::class.java) }

    override fun getItemsData(): Call<Items> {
        TODO("Not yet implemented")
    }

}