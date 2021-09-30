package com.sodiqjon.online_shop.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryModel(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    val id: Int,
    val title: String,
    val icon: String,
    var checked: Boolean=false

)
