package com.mrwhoknows.ecommerce_mob_app.presentation.ui.product_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductListViewModel
@ViewModelInject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    val productList: MutableState<List<ProductMeta>> = mutableStateOf(listOf())

    fun getProductList() {
        viewModelScope.launch {
            productList.value = repository.getProductMetaList()
        }
    }
}