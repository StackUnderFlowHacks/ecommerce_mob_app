package com.mrwhoknows.ecommerce_mob_app.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.ecommerce_mob_app.network.ProductService
import kotlinx.coroutines.launch

class HomeViewModel
@ViewModelInject constructor(
    private val service: ProductService
) : ViewModel() {

    fun getProducts() {
        viewModelScope.launch {
            val result = service.getProducts()
            val product7 = service.getProductById("7")

            println("result = ${result.response}")
            println("product = ${product7.response}")
        }
    }

}