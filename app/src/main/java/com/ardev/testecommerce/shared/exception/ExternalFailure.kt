/*
 * Created by Louis Solo on Apr-10
 * Copyright (c) 2020 . All rights reserved.
 */

package com.ardev.testecommerce.shared.exception

import com.ardev.testecommerce.shared.extension.empty

sealed class ExternalFailure : Failure.FeatureFailure() {

    object Unauthorized : ExternalFailure(){
        operator fun invoke(message: String): Failure {
            this.message = message ?: ""
            return this
        }
    }

    object EmailExisted : ExternalFailure()

    object EmailNotExisted : ExternalFailure()

    object PhoneExisted : ExternalFailure()

    object PhoneNotExisted : ExternalFailure()

    object SendVerifyEmailFailed : ExternalFailure()

    object VerifyEmailAlreadyExist : ExternalFailure()

    object OTPFailure : ExternalFailure()

    object Forbidden : ExternalFailure()

    object EmailRecoverNotExisted : ExternalFailure()

    object PageNotFound : ExternalFailure()

    object BadRequest : ExternalFailure(){
        operator fun invoke(message: String): Failure {
            this.message = message
            return this
        }
    }

    sealed class EmailSocial : ExternalFailure() {
        object Facebook : EmailSocial()
        object FacebookRecover : EmailSocial()

        object Google : EmailSocial()
        object GoogleRecover : EmailSocial()
    }

    object UnderMaintain : ExternalFailure(){
        operator fun invoke(message: String): Failure {
            this.message = message
            return this
        }
    }

    object EmailUnVerify : ExternalFailure(){
        operator fun invoke(message: String?): Failure {
            this.message = message?: String.empty()
            return this
        }
    }

    object AlloHostError : ExternalFailure(){
        operator fun invoke(message: String?): Failure {
            this.message = message?: String.empty()
            return this
        }
    }

    object PaymentRequired  : ExternalFailure(){
        operator fun invoke(message: String?): Failure {
            this.message = message?: String.empty()
            return this
        }
    }
}