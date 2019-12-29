package com.georgcantor.storetest.viewmodel

import com.georgcantor.storetest.model.local.ProductsDao
import kotlinx.coroutines.launch

class ProductViewModel(private val dao: ProductsDao) : BaseViewModel() {

    fun buyProduct(id: Int) {
        ioScope.launch {
            dao.updateQuantityById(id)
        }
    }

}