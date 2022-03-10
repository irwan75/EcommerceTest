package com.ardev.testecommerce.shared.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

inline fun <reified T : ViewModel> viewModel(
    storeOwner: ViewModelStoreOwner,
    factory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(storeOwner, factory).get(T::class.java)
    vm.body()
    return vm
}
