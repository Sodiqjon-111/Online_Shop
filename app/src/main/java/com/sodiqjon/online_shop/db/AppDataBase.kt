package com.sodiqjon.online_shop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sodiqjon.online_shop.model.CategoryModel
import com.sodiqjon.online_shop.model.ProductModel

@Database(entities = [ProductModel::class, CategoryModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract var productDao:ProductDao
    abstract var categoryDao:CategoryDao
    companion object {
        var INSTANCE: AppDataBase? = null

        fun initDatabase(context: Context) {
            if (INSTANCE == null) {
                synchronized(Appendable::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,AppDataBase::class.java,"shop").build()

                }
            }
        }

        fun getDatabase():AppDataBase{
            return INSTANCE!!
        }
    }
}