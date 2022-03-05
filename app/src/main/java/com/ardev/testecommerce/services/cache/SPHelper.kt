package com.ardev.testecommerce.services.cache

import android.content.Context
import android.content.SharedPreferences
import com.ardev.testecommerce.shared.extension.empty
import javax.inject.Singleton

@Singleton
open class SPHelper constructor(private val context: Context) : CacheBehaviour {

    companion object {
        private const val PACKAGE_NAME = "com.smartosc.appollo11";
    }

    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);
    }

    override fun get(key: String): String? {
        return try {
            sharedPreferences.getString(key, String.empty())
        } catch (ex: Throwable) {
            String.empty()
        }
    }

    override fun save(key: String, value: String): Boolean {
        return try {
            sharedPreferences.edit().putString(key, value).apply()
            return true
        } catch (ex: Throwable) {
            false
        }
    }

    override fun remove(key: String): Boolean {
        return try {
            sharedPreferences.edit().remove(key).commit()
            return true
        } catch (ex: Throwable) {
            false
        }
    }

    override fun clear(): Boolean {
        return try {
            sharedPreferences.edit().clear().apply()
            return true
        } catch (ex: Throwable) {
            false
        }
    }

}