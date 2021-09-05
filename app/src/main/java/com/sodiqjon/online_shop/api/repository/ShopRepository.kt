package com.sodiqjon.online_shop.api.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.sodiqjon.online_shop.api.NetworkManager
import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.Offer_model
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.model.request.GetProductsById
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

import io.reactivex.schedulers.Schedulers.io
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.schedulers.Schedulers
import rx.schedulers.Schedulers.io

class ShopRepository {
    val compositeDisposable = CompositeDisposable()

    fun getCategory(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<Categories_model>>

    ) {

        compositeDisposable.add(
            NetworkManager.getApiService().getCategory()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<Categories_model>>>() {
                    override fun onNext(t: BaseResponse<List<Categories_model>>) {

                        if (t.success) {
                            success.value = t.data
                        } else {
                            error.value = t.messege
                        }
                    }

                    override fun onError(e: Throwable) {

                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })


        )
    }

    fun getTopProduct(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<TopProducts_model>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getTopProducts()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<TopProducts_model>>>() {
                    override fun onNext(t: BaseResponse<List<TopProducts_model>>) {

                        if (t.success) {
                            success.value = t.data
                        } else {
                            error.value = t.messege
                        }
                    }

                    override fun onError(e: Throwable) {

                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })


        )
    }

    fun getOffer(
        error: MutableLiveData<String>, progress: MutableLiveData<Boolean>,
        success: MutableLiveData<List<Offer_model>>
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkManager.getApiService().getOffers()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<Offer_model>>>() {
                    override fun onNext(t: BaseResponse<List<Offer_model>>) {
                        progress.value = false
                        if (t.success) {
                            success.value = t.data
                        } else {
                            error.value = t.messege
                        }
                    }

                    override fun onError(e: Throwable) {
                        progress.value = false
                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })


        )
    }


    fun getCategoryProducts(id:Int,
        error: MutableLiveData<String>,
        success: MutableLiveData<List<TopProducts_model>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getCategoryProducts(id)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<TopProducts_model>>>() {
                    override fun onNext(t: BaseResponse<List<TopProducts_model>>) {

                        if (t.success) {
                            success.value = t.data
                        } else {
                            error.value = t.messege
                        }
                    }

                    override fun onError(e: Throwable) {

                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })


        )
    }
    fun getProductsByid(id:List<Int>,
                            error: MutableLiveData<String>,
                            success: MutableLiveData<List<TopProducts_model>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getProductsByid(GetProductsById(id))
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<TopProducts_model>>>() {
                    override fun onNext(t: BaseResponse<List<TopProducts_model>>) {

                        if (t.success) {
                            success.value = t.data
                          //  t.data.forEach { it.cartCount = PrefUtills.getCartCount(it)}
                            } else {
                            error.value = t.messege
                        }
                    }

                    override fun onError(e: Throwable) {

                        error.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })


        )
    }
}