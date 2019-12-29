package com.georgcantor.storetest.viewmodel

import androidx.lifecycle.MutableLiveData
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.model.local.ProductsDao
import kotlinx.coroutines.launch

class UpdateViewModel(private val dao: ProductsDao) : BaseViewModel() {

    val updatedProduct = MutableLiveData<Product>()

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

    fun setUpdatedProduct(product: Product?) {
        updatedProduct.value = product
    }

}