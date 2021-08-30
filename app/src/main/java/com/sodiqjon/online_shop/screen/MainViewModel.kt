package com.sodiqjon.online_shop.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sodiqjon.online_shop.api.repository.ShopRepository
import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.Offer_model
import com.sodiqjon.online_shop.model.TopProducts_model

class MainViewModel : ViewModel() {


    val repository = ShopRepository()
    val error = MutableLiveData<String>()


    val offersData = MutableLiveData<List<Offer_model>>()
    val categoriesData = MutableLiveData<List<Categories_model>>()
    val topPoductsData = MutableLiveData<List<TopProducts_model>>()

    fun getOffer() {
        repository.getOffer(error, offersData)
    }

    fun getCategory() {
        repository.getCategory(error, categoriesData)
    }

    fun getTopProducts() {
        repository.getTopProduct(error, topPoductsData)
    }

}