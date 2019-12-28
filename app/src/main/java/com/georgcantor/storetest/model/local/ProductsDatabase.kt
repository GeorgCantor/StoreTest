package com.georgcantor.storetest.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.georgcantor.storetest.model.Product

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)
abstract class ProductsDatabase : RoomDatabase() {

    companion object {
        private const val dbName = "products_db"

        fun buildDefault(context: Context) = Room.databaseBuilder(
            context,
            ProductsDatabase::class.java,
            dbName
        )
            .build()
    }

    abstract fun dao(): ProductsDao

}