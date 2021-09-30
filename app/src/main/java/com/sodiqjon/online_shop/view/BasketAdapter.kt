package com.sodiqjon.online_shop.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.utils.Constants
import kotlinx.android.synthetic.main.item_bucket.view.*
import kotlinx.android.synthetic.main.recycler_2.view.*

class BasketAdapte(val items:List<ProductModel>):RecyclerView.Adapter<BasketAdapte.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bucket,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
    val item=items[position]

        holder.itemView.rv_tv_basket_1.text=item.name
        holder.itemView.rv_tv_basket_2.text=item.price
        Glide.with(holder.itemView).load(Constants.HOST_IMAGE+item.image).into(holder.itemView.image_basket)


        holder.itemView.tv_bucket_number.text= item.cardCount.toString()
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)
}