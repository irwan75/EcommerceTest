/*
 * Created by Louis Solo on Apr-10
 * Copyright (c) 2020 . All rights reserved.
 */

package com.ardev.testecommerce.shared.exception

sealed class InternalFailure : Failure.FeatureFailure() {
    object CustomerNotFound : InternalFailure()
}