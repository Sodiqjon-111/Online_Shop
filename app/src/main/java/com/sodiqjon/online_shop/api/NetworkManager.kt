package com.sodiqjon.online_shop.api

import com.sodiqjon.online_shop.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {


    var retrofit: Retrofit? = null
    var api: Api? = null



    fun getApiService():Api {
        if (api == null) {
            retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }
}