package com.sodiqjon.online_shop.utils

import com.orhanobut.hawk.Hawk
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.model.request.Bucket_model

object PrefUtils {
    const val PREF_FAVOURITES = "pref_favourites"
    const val PREF_BUCKET = "pref_buckets"


    fun setFavourite(item: TopProducts_model) {
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

    fun checkFavourite(item: TopProducts_model): Boolean {
        val items = Hawk.get(PREF_FAVOURITES, arrayListOf<Int>())
        return items.filter { it == item.id }.firstOrNull() != null

    }


    fun setBuckets(item: TopProducts_model) {
        val items = Hawk.get<ArrayList<Bucket_model>>(PREF_BUCKET, arrayListOf<Bucket_model>())
        val cart = items.filter { it.product_id == item.id }.firstOrNull()
        if (cart != null) {
            if (item.cardCount > 0) {
                cart.count = item.cardCount
            } else {
                items.remove(cart)
            }
        } else {
            val newCart = Bucket_model(item.id, item.cardCount)
            items.add(newCart)
        }


        Hawk.put(PREF_BUCKET, items)
    }

    fun getBucketList(): ArrayList<Bucket_model> {
        return Hawk.get(PREF_BUCKET, arrayListOf<Bucket_model>())
    }

    fun getCardCount(item: TopProducts_model): Int {
        val items = Hawk.get<ArrayList<Bucket_model>>(PREF_FAVOURITES, arrayListOf<Bucket_model>())
        return items.filter { it.product_id == item.id }.firstOrNull()?.count ?: 0

    }
}