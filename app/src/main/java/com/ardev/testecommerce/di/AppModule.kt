package com.ardev.testecommerce.di

import android.app.Application
import android.content.Context
import com.ardev.testecommerce.base.AndroidApplication
import com.ardev.testecommerce.repository.ItemsRepository
import com.ardev.testecommerce.services.cache.DbHelper
import com.ardev.testecommerce.services.cache.dao.items.DaoItems
import com.ardev.testecommerce.shared.constans.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getAppDb(context: Application): DbHelper{
        return DbHelper.getDatabase(context)
    }

    @Provides
    @Singleton
    fun getDao(appDb: DbHelper): DaoItems{
        return appDb.daoItems()
    }



}