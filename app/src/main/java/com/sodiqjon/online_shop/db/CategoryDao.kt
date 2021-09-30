package com.sodiqjon.online_shop.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sodiqjon.online_shop.model.CategoryModel
import kotlinx.coroutines.selects.select

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items:List<CategoryModel>)

    @Query("select * from categories" )
    fun getAllCategories():List<CategoryModel>
}