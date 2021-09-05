package com.sodiqjon.online_shop.screen.bucket

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
import kotlinx.android.synthetic.main.fragment_bucket.*
import kotlinx.android.synthetic.main.fragment_star.*

class BucketFragment : Fragment() {
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
       //  viewModel.progress.observe(this).get(MainViewModel)
        viewModel.topPoductsData.observe(this, androidx.lifecycle.Observer {
            recycler_bucket.adapter= TopProductAdapter(it)
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bucket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_prodcts_by_id.layoutManager= LinearLayoutManager(requireActivity())
        viewModel.getProductsById(PrefUtils.getFavouriteList())
    }


}