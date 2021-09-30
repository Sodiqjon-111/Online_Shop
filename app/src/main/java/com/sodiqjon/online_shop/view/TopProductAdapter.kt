package com.sodiqjon.online_shop.view
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.DetailActivity
import com.sodiqjon.online_shop.R
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.utils.Constants
import kotlinx.android.synthetic.main.recycler_2.view.*

class TopProductAdapter( val items: List<ProductModel>) :
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
