package com.mrwhoknows.ecommerce_mob_app.presentation.ui.product

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel
@ViewModelInject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _product: MutableLiveData<Product> = MutableLiveData()
    val product: LiveData<Product> = _product

    fun getProductById(id: String) {
        viewModelScope.launch {
            _product.value = repository.getProductById(id)
        }
    }

}