package com.ardev.testecommerce.services.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ardev.testecommerce.R
import com.ardev.testecommerce.models.others.Items
import com.ardev.testecommerce.services.cache.dao.items.DaoItems
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Database(entities = [Items::class], version = 1, exportSchema = false)
abstract class DbHelper : RoomDatabase() {

    abstract fun daoItems(): DaoItems

    companion object {
        @Volatile
        private var INSTANCE: DbHelper? = null

        fun getDatabase(context: Context): DbHelper{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DbHelper::class.java,
                    context.getString(R.string.db_name)
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}