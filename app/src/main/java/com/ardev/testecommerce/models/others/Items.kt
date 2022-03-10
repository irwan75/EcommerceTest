package com.ardev.testecommerce.models.others

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ardev.testecommerce.base.BaseModel
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.shared.constans.AppConstant
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = AppConstant.EntityTable.TABLE_ITEMS)
data class Items(

    @Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "details")
    @Json(name = "details")
    var details: String? = null,

    @ColumnInfo(name = "content")
    @Json(name = "content")
    var content: String? = null,

) : BaseModel() {

    companion object {
        fun empty() = Items()

    }

    fun fromResponseItemsData(id: Int, title: String, body: String): Items {
        return Items(
            id= id,
            details = body,
            content = title
        )
    }

    fun fromListResponseItemsData(dataList: List<ResponseItemsData>): List<Items> {
        return dataList.map { Items(id = it.id, details = it.body, content = it.title) }
    }

}


