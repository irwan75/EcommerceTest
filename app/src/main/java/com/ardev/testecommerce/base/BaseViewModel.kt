package com.ardev.testecommerce.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardev.testecommerce.shared.exception.Failure
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    var mJob: Job? = null

    override fun onCleared() {
        super.onCleared()
        if (shouldCancelJob()) {
            mJob?.cancel()
        }
    }

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

    protected fun shouldCancelJob(): Boolean {
        return true
    }

    protected fun <K, V> lazyMap(initializer: (K) -> V): Map<K, V> {
        val map = mutableMapOf<K, V>()
        return map.withDefault { key ->
            val newValue = initializer(key)
            map[key] = newValue
            return@withDefault newValue
        }
    }
}