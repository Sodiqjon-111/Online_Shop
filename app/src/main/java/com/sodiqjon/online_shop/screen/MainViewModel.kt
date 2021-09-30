package com.sodiqjon.online_shop.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sodiqjon.online_shop.api.repository.ShopRepository
import com.sodiqjon.online_shop.db.AppDataBase
import com.sodiqjon.online_shop.model.CategoryModel
import com.sodiqjon.online_shop.model.OfferModel
import com.sodiqjon.online_shop.model.ProductModel

class MainViewModel : ViewModel() {


    val repository = ShopRepository()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()
    val offersData = MutableLiveData<List<OfferModel>>()
    val categoriesData = MutableLiveData<List<CategoryModel>>()
    val productsData = MutableLiveData<List<ProductModel>>()

    fun getOffer() {
        repository.getOffer(error, progress, offersData)
    }

    fun getCategory() {
        repository.getCategory(error, categoriesData)
    }

    fun getTopProducts() {
        repository.getTopProduct(error, productsData)
    }


    fun getCategoryProducts(id: Int) {
        repository.getCategoryProducts(id, error, productsData)
    }

    fun getProductsById(id: List<Int>) {
        repository.getProductsByid(id, error, productsData)
    }
    fun insertAllProducts2DB(items:List<ProductModel>){
        AppDataBase.getDatabase().productDao.insertAll(items)


    }
    fun getAllDBProducts(){
        productsData.value=AppDataBase.getDatabase().productDao.getAllProducts()
    }

}