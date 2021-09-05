package com.sodiqjon.online_shop.view

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.createNavigateOnClickListener
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.sodiqjon.online_shop.DetailActivity
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.screen.home.HomeFragment
import com.sodiqjon.online_shop.utils.Constants
import kotlinx.android.synthetic.main.category_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.recycler_2.view.*
import java.security.Key
import kotlin.coroutines.coroutineContext

class TopProductAdapter( val items: List<TopProducts_model>) :
    RecyclerView.Adapter<TopProductAdapter.ItemHolder>() {

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_2, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
           // itemClickListener.invoke(item)
            //view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment)

            val intent=Intent(it.context,DetailActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA,item)
            it.context.startActivity(intent)

        }
        holder.itemView.rv_tv_1.text = item.name
        holder.itemView.rv_tv_2.text = item.price
        Glide.with(holder.itemView.context)
            .load(Constants.HOST_IMAGE+item.image).into(holder.itemView.image_rec_2)
        val bundle = Bundle()
        bundle.putString("Bundle", item.name)


    }

}
