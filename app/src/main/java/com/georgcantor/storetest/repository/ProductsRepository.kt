package com.georgcantor.storetest.repository

import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.model.local.ProductsDao
import com.georgcantor.storetest.model.remote.FakeServer

class ProductsRepository(private val dao: ProductsDao) {

    suspend fun getProducts(): List<Product> {
        val products = dao.getAll()
        if (products.isNotEmpty()) return products

        return FakeServer.getProducts()
    }

}