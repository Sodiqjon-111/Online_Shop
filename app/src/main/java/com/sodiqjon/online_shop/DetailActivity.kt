package com.sodiqjon.online_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.sodiqjon.online_shop.model.TopProducts_model
import com.sodiqjon.online_shop.utils.Constants
import com.sodiqjon.online_shop.utils.PrefUtils
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var item: TopProducts_model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btn_back.setOnClickListener {
            finish()
        }

         btn_like.setOnClickListener {
             PrefUtils.setFavourite(item)

             if (PrefUtils.checkFavourite(item)){
              btn_like.setImageResource(R.drawable.like_red)
             } else{
                 btn_like.setImageResource(R.drawable.like)
             }
         }

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as TopProducts_model

        tv_1.text= item.name
        tv_2.text = item.name
        tv_3.text = item.price


        if(PrefUtils.getCardCount(item)>0){
            btn_add_to_bag.visibility= View.GONE
        }
        if (PrefUtils.checkFavourite(item)){
            btn_like.setImageResource(R.drawable.like_red)
        } else{
            btn_like.setImageResource(R.drawable.like)
        }
        Glide.with(this).load(Constants.HOST_IMAGE + item.image).into(im_1)

        btn_add_to_bag.setOnClickListener {
            item.cardCount=1
            PrefUtils.setBuckets(item)
            Toast.makeText(this, "Product added to bucket", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}