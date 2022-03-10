package com.ardev.testecommerce.services.cloud

import com.ardev.testecommerce.BuildConfig
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CustomInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        val moreHeaders: Headers = request.headers.newBuilder()
            .add("mobile-version", BuildConfig.VERSION_NAME)
//            .add("Authorization", "Bearer $token")
            .add("mobile-build-number", BuildConfig.VERSION_CODE.toString())
            .build()

        request = request.newBuilder().headers(moreHeaders).build()

        return chain.proceed(request)
    }
}