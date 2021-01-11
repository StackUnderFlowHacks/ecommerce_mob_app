package com.mrwhoknows.ecommerce_mob_app.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepository
import kotlinx.coroutines.launch

class HomeViewModel
@ViewModelInject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    fun getProducts() {
        viewModelScope.launch {
            val result = repository.getProductById("7")
            val resultList = repository.getProductMetaList()

            println("result = $result")
            resultList.forEachIndexed { index, productMeta ->
                println("${index + 1} = $productMeta")
            }
        }
    }

}