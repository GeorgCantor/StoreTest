package com.georgcantor.storetest.viewmodel

import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.model.local.ProductsDao
import kotlinx.coroutines.launch

class UpdateViewModel(private val dao: ProductsDao) : BaseViewModel() {

    fun addProduct(product: Product) {
        ioScope.launch {
            dao.insert(product)
        }
    }

    fun updateProduct(product: Product) {
        ioScope.launch {
            dao.updateById(
                product.id,
                product.model ?: "",
                product.price,
                product.quantity
            )
        }
    }

}