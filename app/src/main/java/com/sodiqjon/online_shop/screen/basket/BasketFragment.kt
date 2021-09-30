package com.sodiqjon.online_shop.screen.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.screen.MainViewModel
import com.sodiqjon.online_shop.utils.PrefUtils
import com.sodiqjon.online_shop.view.BasketAdapte
import kotlinx.android.synthetic.main.fragment_basket.*


class BasketFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
       //  viewModel.progress.observe(this).get(MainViewModel)
        viewModel.productsData.observe(this, androidx.lifecycle.Observer {
            recycler_basket.adapter= BasketAdapte(it)
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_basket.layoutManager= LinearLayoutManager(requireActivity())
       loadData()
    }

    fun loadData(){
        viewModel.getProductsById(PrefUtils.getBasketList().map { it.product_id })
    }


}