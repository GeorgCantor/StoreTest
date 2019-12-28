package com.georgcantor.storetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.georgcantor.storetest.model.Product.Product.tableName

@Entity(tableName = tableName)
data class Product(
    @PrimaryKey
    val id: Int,
    val model: String,
    val price: Long,
    val quantity: Int
) {

    object Product {
        const val tableName = "products"

        object Column {
            val id = "id"
            val model = "model"
            val price = "price"
            val quantity = "quantity"
        }
    }

}