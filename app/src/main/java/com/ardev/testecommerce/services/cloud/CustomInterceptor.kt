package com.ardev.testecommerce.services.cloud

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CustomInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        request = request.newBuilder()
            .addHeader("headerKey0", "HeaderVal0")
            .addHeader("headerKey0", "HeaderVal0--NotReplaced/NorUpdated") //new header added
            .build()

        //alternative

        //alternative
        val moreHeaders: Headers = request.headers.newBuilder()
            .add("headerKey1", "HeaderVal1")
            .add("headerKey2", "HeaderVal2")
            .set(
                "headerKey2",
                "HeaderVal2--UpdatedHere"
            ) // existing header UPDATED if available, else added.
            .add("headerKey3", "HeaderKey3")
            .add("headerLine4 : headerLine4Val") //line with `:`, spaces doesn't matter.
            .removeAll("headerKey3") //Oops, remove this.
            .build()

        request = request.newBuilder().headers(moreHeaders).build()

        /* ##### List of headers ##### */
        // headerKey0: HeaderVal0
        // headerKey0: HeaderVal0--NotReplaced/NorUpdated
        // headerKey1: HeaderVal1
        // headerKey2: HeaderVal2--UpdatedHere
        // headerLine4: headerLine4Val


        /* ##### List of headers ##### */
        // headerKey0: HeaderVal0
        // headerKey0: HeaderVal0--NotReplaced/NorUpdated
        // headerKey1: HeaderVal1
        // headerKey2: HeaderVal2--UpdatedHere
        // headerLine4: headerLine4Val
        return chain.proceed(request)
    }
}