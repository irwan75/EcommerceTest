package com.ardev.testecommerce.models

import com.ardev.testecommerce.base.BaseModel

//@JsonClass(generateAdapter = true)
open class Items : BaseModel() {

    companion object{
        fun empty() = Items()
    }

//    @Json(name = "id")
    var id: String? = null

//    @Json(name = "sku")
    var details: String? = null

//    @Json(name = "name")
    var content: String? = null


}