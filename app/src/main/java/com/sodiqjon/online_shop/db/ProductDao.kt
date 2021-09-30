package com.sodiqjon.online_shop.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sodiqjon.online_shop.model.CategoryModel
import com.sodiqjon.online_shop.model.ProductModel

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items:List<ProductModel>)


    @Query("select * from products" )
    fun getAllProducts():List<ProductModel>
}