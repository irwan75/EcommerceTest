package com.ardev.testecommerce.services.cloud

import android.content.Context
import com.ardev.testecommerce.BuildConfig
import com.ardev.testecommerce.base.AndroidApplication
import com.ardev.testecommerce.services.cloud.api.ApiItems
import com.ardev.testecommerce.services.cloud.clients.ClientItems
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.X509TrustManager

object NetworkInstance {


    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val CONNECTION_TIMEOUT: Long = 60
    private val customInterceptor: CustomInterceptor = CustomInterceptor()

    private fun getLoggingHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)

        builder.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })

        builder.addInterceptor(interceptor = customInterceptor)

//        { chain ->
//            val builders = chain.request().newBuilder()
////            if (token.isNotEmpty() ) {
////                builder.header("Authorization", "Bearer $token")
////            }
////            if (null != selectedStore) {
////                builder.header("source-code", "$storeCode")
////            }
//            builders.header("mobile-version", BuildConfig.VERSION_NAME)
//            builders.header("mobile-build-number", "${BuildConfig.VERSION_CODE}")
//            builders.header("mobile-os", "Android")
//            chain.proceed(builders.build())
//        }

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                ChuckerInterceptor.Builder(AndroidApplication.context)
                    .collector(ChuckerCollector(AndroidApplication.context))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
        }


        return builder.build()
    }



    @Singleton
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    private val retrofit: Retrofit = Retrofit.Builder().client(getLoggingHttpClient()).baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

    private val apiItems: ApiItems by lazy {
        retrofit.create(ApiItems::class.java)
    }

    val clientItems = ClientItems(apiItems)

}