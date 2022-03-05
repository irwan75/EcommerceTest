package com.ardev.testecommerce.interactor

import com.ardev.testecommerce.shared.exception.Failure
import com.ardev.testecommerce.shared.helper.Either
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, job: Job?, onResult: (Either<Failure, Type>) -> Unit = {}) {
        if (null == job) {
            throw UnsupportedOperationException("Job must be initialized")
        }
        val backgroundJob = CoroutineScope(job + Dispatchers.IO).async { run(params) }
        CoroutineScope(job + Dispatchers.Main).launch { onResult(backgroundJob.await()) }
    }

    class None
}