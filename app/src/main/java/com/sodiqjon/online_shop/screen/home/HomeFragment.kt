package com.sodiqjon.online_shop.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.screen.MainViewModel
import com.sodiqjon.online_shop.view.CategoryAdapter
import com.sodiqjon.online_shop.view.TopProductAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        res_category.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        viewModel.error.observe(requireActivity(), Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        viewModel.offersData.observe(requireActivity(), Observer {
            carouselView.setImageListener { position, imageView ->
                Glide.with(requireActivity()).load("http://osonsavdo.sd-group.uz/images/${it[position].image}")
                    .into(imageView)
            }
            carouselView.pageCount =it.count()
        })

        viewModel.categoriesData.observe(requireActivity(), Observer {
            res_category.adapter = CategoryAdapter(it)
        })


        viewModel.topPoductsData.observe(requireActivity(), Observer {
            recycler_2.adapter=TopProductAdapter(it)
        })






        loadData()
    }

    fun loadData() {
        viewModel.getOffer()
        viewModel.getCategory()
        viewModel.getTopProducts()
    }


}