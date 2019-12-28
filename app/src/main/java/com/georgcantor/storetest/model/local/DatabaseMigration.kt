package com.georgcantor.storetest.model.local

import androidx.room.migration.Migration

internal object DatabaseMigration {

    const val latestVersion = 1

    val allMigrations: Array<Migration>
        get() = arrayOf()

    object V1 {
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

}