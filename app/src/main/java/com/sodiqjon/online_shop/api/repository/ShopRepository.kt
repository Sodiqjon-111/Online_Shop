package com.sodiqjon.online_shop.api.repository

import androidx.lifecycle.MutableLiveData
import com.sodiqjon.online_shop.api.NetworkManager
import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.CategoryModel
import com.sodiqjon.online_shop.model.OfferModel
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.model.request.GetProductsById
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver


class ShopRepository {
    val compositeDisposable = CompositeDisposable()

    fun getCategory(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<CategoryModel>>

    ) {

        compositeDisposable.add(
            NetworkManager.getApiService().getCategory()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<CategoryModel>>>() {
                    override fun onNext(t: BaseResponse<List<CategoryModel>>) {

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
        success: MutableLiveData<List<ProductModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getTopProducts()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<ProductModel>>>() {
                    override fun onNext(t: BaseResponse<List<ProductModel>>) {

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
        success: MutableLiveData<List<OfferModel>>
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkManager.getApiService().getOffers()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<OfferModel>>>() {
                    override fun onNext(t: BaseResponse<List<OfferModel>>) {
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
        success: MutableLiveData<List<ProductModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getCategoryProducts(id)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<ProductModel>>>() {
                    override fun onNext(t: BaseResponse<List<ProductModel>>) {

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
                            success: MutableLiveData<List<ProductModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getProductsByid(GetProductsById(id))
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponse<List<ProductModel>>>() {
                    override fun onNext(t: BaseResponse<List<ProductModel>>) {

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