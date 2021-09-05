package com.sodiqjon.online_shop.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.model.request.Bucket_model
import com.sodiqjon.online_shop.utils.Constants
import kotlinx.android.synthetic.main.item_bucket.view.*

class BucketAdapte(val items:List<TopProducts_model>):RecyclerView.Adapter<BucketAdapte.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_bucket,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
    val item=items[position]

        holder.itemView.rv_tv_bucket_1.text=item.name
        holder.itemView.rv_tv_bucket_2.text=item.price
        Glide.with(holder.itemView).load(Constants.HOST_IMAGE+item).into(holder.itemView.image_bucket)


        holder.itemView.tv_bucket_number.text= item.cardCount.toString()
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)
}