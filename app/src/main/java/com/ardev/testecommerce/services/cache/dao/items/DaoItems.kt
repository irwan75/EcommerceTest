package com.ardev.testecommerce.services.cache.dao.items

import androidx.room.*
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.models.response.ResponseItemsData
import com.ardev.testecommerce.shared.constans.AppConstant
import retrofit2.Response

@Dao
interface DaoItems {

    companion object{
        private const val GET_DATA_BYID = "SELECT * FROM ${AppConstant.EntityTable.TABLE_ITEMS} where id = :id"
        private const val UPDATE_DATA_BYID = "UPDATE ${AppConstant.EntityTable.TABLE_ITEMS} SET content = :content WHERE id = :id"
        private const val DELETE_DATA_BYID = "DELETE FROM ${AppConstant.EntityTable.TABLE_ITEMS} where id = :id"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveItem(item: Items)

    @Update
    suspend fun updateItem(item: Items)

    @Delete
    suspend fun deleteItem(item: Items)

    // for custom query
    @Query(GET_DATA_BYID)
    suspend fun getItemById(id: Int): Items

    @Query(DELETE_DATA_BYID)
    suspend fun deleteItemById(id: Int)
//
    @Query(UPDATE_DATA_BYID)
    suspend fun updateItemById(id: Int, content: String)

}