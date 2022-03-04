/*
 * Created by Louis Solo on Mar-25
 * Copyright (c) 2020 . All rights reserved.
 */

package com.ardev.testecommerce.shared.exception

import com.ardev.testecommerce.shared.extension.empty

sealed class Failure {
    var message: String = String.empty()

    object NetworkConnection : Failure()

    object Timeout : Failure()

    object ServerError : Failure() {
        operator fun invoke(message: String): Failure {
            this.message = message
            return this
        }

    }

    object InternalError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}