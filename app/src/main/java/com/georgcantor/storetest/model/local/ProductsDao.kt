package com.georgcantor.storetest.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.georgcantor.storetest.model.Product

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product): Long

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM products")
    suspend fun deleteAll()

    @Query("SELECT * FROM products WHERE id LIKE :id")
    suspend fun getById(id: Int): List<Product>

    @Query("SELECT * FROM products")
    suspend fun getAll(): List<Product>

    @Query("UPDATE products SET quantity = quantity-1 WHERE id LIKE :id")
    suspend fun updateById(id: Int)

}