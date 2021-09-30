package com.sodiqjon.online_shop.utils

import com.orhanobut.hawk.Hawk
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.model.request.BasketModel

object PrefUtils {
    const val PREF_FAVOURITES = "pref_favourites"
    const val PREF_BASKET = "pref_buckets"


    fun setFavourite(item: ProductModel) {
        val items = Hawk.get(PREF_FAVOURITES, arrayListOf<Int>())

        if (items.filter { it == item.id }.firstOrNull() != null) {
            items.remove(item.id)
        } else {
            items.add(item.id)
        }
        Hawk.put(PREF_FAVOURITES, items)
    }


    fun getFavouriteList(): ArrayList<Int> {
        return Hawk.get(PREF_FAVOURITES, arrayListOf<Int>())
    }

    fun checkFavourite(item: ProductModel): Boolean {
        val items = Hawk.get(PREF_FAVOURITES, arrayListOf<Int>())
        return items.filter { it == item.id }.firstOrNull() != null

    }


    fun setBaskets(item: ProductModel) {
        val items = Hawk.get<ArrayList<BasketModel>>(PREF_BASKET, arrayListOf<BasketModel>())

        val cart = items.filter { it.product_id == item.id }.firstOrNull()

        if (cart != null) {
            if (item.cardCount > 0) {
                cart.count = item.cardCount
            } else {
                items.remove(cart)
            }
        } else {
            val newCart = BasketModel(item.id, item.cardCount)
            items.add(newCart)
        }


        Hawk.put(PREF_BASKET, items)
    }

    fun getBasketList(): ArrayList<BasketModel> {
        return Hawk.get(PREF_BASKET, arrayListOf<BasketModel>())
    }

    fun getCardCount(item: ProductModel): Int {
        val items = Hawk.get<ArrayList<BasketModel>>(PREF_BASKET, arrayListOf<BasketModel>())
        return items.filter { it.product_id == item.id }.firstOrNull()?.count ?: 0

    }
}