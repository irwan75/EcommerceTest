package com.ardev.testecommerce.models.others

import com.ardev.testecommerce.base.BaseModel
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class Items(
    @Json(name = "id")
    var id: String? = null,
    @Json(name = "sku")
    var details: String? = null,
    @Json(name = "name")
    var content: String? = null,
) : BaseModel() {

    companion object {
        fun empty() = Items()

    }

    fun fromResponseItemsData(userId: Int, id: Int, title: String, body: String): Items {
        return Items(
            id= id.toString(),
            details = body,
            content = title
        )
    }

    fun fromListResponseItemsData(dataList: List<ResponseItemsData>): List<Items> {
        return dataList.map { Items(id = it.id.toString(), details = it.body, content = it.title) }
    }

}


