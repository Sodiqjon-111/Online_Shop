package com.sodiqjon.online_shop.view

import android.content.ContentValues.TAG
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Categories_model
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.category_layout.view.*
interface  CategoryAdpterCallBack{
    fun onClickItem(item:Categories_model)
}
class CategoryAdapter(val items:List<Categories_model>,val callBack: CategoryAdpterCallBack):RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {

    class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       return  ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
      val item=items[position]
        holder.itemView.setOnClickListener{
          items.forEach{
              it.checked=false
          }

            item.checked=true
            callBack.onClickItem(item)
            notifyDataSetChanged()

            Log.i(TAG, " ${items[position]}")
        }
        holder.itemView.tv_category.text=item.title
        if (item.checked){
            holder.itemView.card_category.setCardBackgroundColor(ContextCompat
                .getColor(holder.itemView.context,R.color.category))
            holder.itemView.tv_category.setTextColor(Color.WHITE)
        }
        else{
            holder.itemView.card_category.setCardBackgroundColor(ContextCompat
                .getColor(holder.itemView.context,R.color.white))
            holder.itemView.tv_category.setTextColor(Color.BLACK)

        }
    }
    override fun getItemCount(): Int {
        return items.count()
    }
}