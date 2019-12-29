package com.georgcantor.storetest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.repository.ProductsRepository
import kotlinx.coroutines.launch

class StoreViewModel(private val repository: ProductsRepository) : BaseViewModel() {

    private val products = MutableLiveData<List<Product>>()

    fun getProducts(): LiveData<List<Product>> {
        ioScope.launch {
            products.postValue(repository.getProducts())
        }

        return products
    }

}