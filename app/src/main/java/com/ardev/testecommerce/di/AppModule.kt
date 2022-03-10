package com.ardev.testecommerce.di

import android.app.Application
import com.ardev.testecommerce.base.AndroidApplication
import com.ardev.testecommerce.services.cache.DbHelper
import com.ardev.testecommerce.services.cache.dao.items.DaoItems
import com.ardev.testecommerce.services.cloud.CustomInterceptor
import com.ardev.testecommerce.services.cloud.api.ApiItems
import com.ardev.testecommerce.services.cloud.clients.ClientItems
import com.ardev.testecommerce.shared.constans.AppConstant
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getAppDb(context: Application): DbHelper {
        return DbHelper.getDatabase(context)
    }

    @Provides
    @Singleton
    fun getDao(appDb: DbHelper): DaoItems {
        return appDb.daoItems()
    }

    @Singleton
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    private val customInterceptor: CustomInterceptor = CustomInterceptor()

    @Singleton
    fun getLoggingHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().connectTimeout(AppConstant.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConstant.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(AppConstant.Network.CONNECTION_TIMEOUT, TimeUnit.SECONDS)

        builder.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })

        builder.addInterceptor(interceptor = customInterceptor)

        builder.addInterceptor(
            ChuckerInterceptor.Builder(AndroidApplication.context)
                .collector(ChuckerCollector(AndroidApplication.context))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )


        return builder.build()
    }


    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().client(getLoggingHttpClient())
            .baseUrl(AppConstant.Network.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Provides
    @Singleton
    fun setApiItems(retrofit: Retrofit): ApiItems {
        return retrofit.create(ApiItems::class.java)
    }

    @Provides
    @Singleton
    fun setClientItems(apiItems: ApiItems): ClientItems{
        return ClientItems(apiItems)
    }


}