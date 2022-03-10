package com.ardev.testecommerce.services.spreferences

interface SPreferencesBehaviour {

    fun get(key: String): String?
    fun save(key: String, value: String): Boolean
    fun remove(key: String): Boolean
    fun clear(): Boolean

}