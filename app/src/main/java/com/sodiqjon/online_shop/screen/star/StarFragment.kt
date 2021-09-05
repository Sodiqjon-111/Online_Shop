package com.sodiqjon.online_shop.screen.star

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.screen.MainViewModel
import com.sodiqjon.online_shop.utils.PrefUtils
import com.sodiqjon.online_shop.view.TopProductAdapter
import io.reactivex.Observable
import io.reactivex.Observer
import kotlinx.android.synthetic.main.fragment_star.*

class StarFragment : Fragment() {

 lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.topPoductsData.observe(this, androidx.lifecycle.Observer {
  recycler_prodcts_by_id.adapter=TopProductAdapter(it)
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_prodcts_by_id.layoutManager=LinearLayoutManager(requireActivity())
        viewModel.getProductsById(PrefUtils.getFavouriteList())
    }


}