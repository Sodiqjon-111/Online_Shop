package com.sodiqjon.online_shop.api

import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Offer_model
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.model.request.GetProductsById

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

interface Api {

    @GET ("get_offers")
    fun getOffers(): io.reactivex.Observable<BaseResponse<List<Offer_model>>>

    @GET ("get_categories")
    fun getCategory():io.reactivex.Observable<BaseResponse<List<Categories_model>>>

    @GET ("get_top_products")
    fun getTopProducts():io.reactivex.Observable<BaseResponse<List<TopProducts_model>>>


    @GET ("get_products/{category_id}")
    fun getCategoryProducts(@Path("category_id") category_id:Int):io.reactivex.Observable<BaseResponse<List<TopProducts_model>>>

    @POST ("get_products_by_ids")
    fun getProductsByid(@Body request:GetProductsById):io.reactivex.Observable<BaseResponse<List<TopProducts_model>>>
}