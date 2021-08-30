package com.sodiqjon.online_shop.view

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.TopProducts_model
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.recycler_2.view.*

class TopProductAdapter(val items: List<TopProducts_model>): RecyclerView.Adapter<TopProductAdapter.ItemHolder>() {

    class ItemHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return  ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_2,parent,false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item=items[position]
        holder.itemView.rv_tv_1.text=item.name
        holder.itemView.rv_tv_2.text=item.price
        Glide.with(holder.itemView.context).load("http://osonsavdo.sd-group.uz/images/${item.image}").into(holder.itemView.image_rec_2)

            //Toast.makeText(this, "${items[position]}", Toast.LENGTH_SHORT).show()

            Log.i(ContentValues.TAG, " ${items[position]}")
        }
      //  holder.itemView.image_rec_2.setImageResource()
    }
