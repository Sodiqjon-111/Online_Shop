package com.sodiqjon.online_shop.api.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.sodiqjon.online_shop.api.NetworkManager
import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.Offer_model
import com.sodiqjon.online_shop.model.TopProducts_model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopRepository {

    fun getCategory(error: MutableLiveData<String>,success: MutableLiveData<List<Categories_model>>) {

        NetworkManager.getApiService().getCategory().enqueue(object :
            Callback<BaseResponse<List<Categories_model>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<Categories_model>>>,
                response: Response<BaseResponse<List<Categories_model>>>
            ) {
                if (response.isSuccessful) {
                    success.value = response.body()!!.data
                    //res_category.adapter = CategoryAdapter(response.body()!!)
                } else {
                    error.value = response.message()
                    // Toast.makeText(this@MainActivity, "xato", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<Categories_model>>>, t: Throwable) {
                error.value = t.localizedMessage
                //Toast.makeText(this@MainActivity, "no connection", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun getTopProduct(error: MutableLiveData<String>,success:MutableLiveData<List<TopProducts_model>>){
        NetworkManager.getApiService().getTopProducts().enqueue(object :
            Callback<BaseResponse<List<TopProducts_model>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<TopProducts_model>>>,
                response: Response<BaseResponse<List<TopProducts_model>>>
            ) {
                if (response.isSuccessful) {
                    success.value = response.body()!!.data
                    //res_category.adapter = CategoryAdapter(response.body()!!)
                } else {
                    error.value = response.message()
                    // Toast.makeText(this@MainActivity, "xato", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<BaseResponse<List<TopProducts_model>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

        })
    }
    fun getOffer(error: MutableLiveData<String>,success:MutableLiveData<List<Offer_model>>) {
        NetworkManager.getApiService().getOffers().enqueue(object : Callback<BaseResponse<List<Offer_model>>> {
            @SuppressLint("CheckResult")
            override fun onResponse(
                call: Call<BaseResponse<List<Offer_model>>> ,
                response: Response<BaseResponse<List<Offer_model>>>
            ) {
                if (response.isSuccessful) {

                    success.value = response.body()!!.data
                    //offers = response.body()!!

                } else {
                    error.value = response.message()
                    //  Toast.makeText(this@MainActivity, "no connection", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<BaseResponse<List<Offer_model>>> , t: Throwable) {
                error.value = t.localizedMessage
                //  Toast.makeText(this@MainActivity, "no connection", Toast.LENGTH_SHORT).show()
            }
        })
    }
}