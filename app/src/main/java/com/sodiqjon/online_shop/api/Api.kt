package com.sodiqjon.online_shop.api

import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.OfferModel
import com.sodiqjon.online_shop.model.CategoryModel
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.model.request.GetProductsById

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @GET ("get_offers")
    fun getOffers(): io.reactivex.Observable<BaseResponse<List<OfferModel>>>

    @GET ("get_categories")
    fun getCategory():io.reactivex.Observable<BaseResponse<List<CategoryModel>>>

    @GET ("get_top_products")
    fun getTopProducts():io.reactivex.Observable<BaseResponse<List<ProductModel>>>


    @GET ("get_products/{category_id}")
    fun getCategoryProducts(@Path("category_id") category_id:Int):io.reactivex.Observable<BaseResponse<List<ProductModel>>>

    @POST ("get_products_by_ids")
    fun getProductsByid(@Body request:GetProductsById):io.reactivex.Observable<BaseResponse<List<ProductModel>>>
}