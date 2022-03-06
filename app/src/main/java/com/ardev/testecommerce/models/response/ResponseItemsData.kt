package com.ardev.testecommerce.models.response

import com.ardev.testecommerce.base.BaseModel
import com.ardev.testecommerce.models.others.Items
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseItemsData(
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "body")
    val body: String
) : BaseModel() {

}

