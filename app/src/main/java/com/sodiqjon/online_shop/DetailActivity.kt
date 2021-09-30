package com.sodiqjon.online_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.orhanobut.hawk.Hawk
import com.sodiqjon.online_shop.model.ProductModel
import com.sodiqjon.online_shop.utils.Constants
import com.sodiqjon.online_shop.utils.PrefUtils
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var item: ProductModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Hawk.init(this).build()

        setSupportActionBar(toolbar_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        btn_like.setOnClickListener {
            PrefUtils.setFavourite(item)

            if (PrefUtils.checkFavourite(item)) {
                btn_like.setImageResource(R.drawable.like_red)
            } else {
                btn_like.setImageResource(R.drawable.like)
            }
        }

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as ProductModel

        tv_detail_1.text = item.name
        tv_detail_2.text = item.name
        tv_detail_3.text = item.price


        if (PrefUtils.getCardCount(item) > 0) {
            btn_addbag.visibility = View.GONE
        }
        if (PrefUtils.checkFavourite(item)) {
            btn_like.setImageResource(R.drawable.like_red)
        } else {
            btn_like.setImageResource(R.drawable.like)
        }


        Glide.with(this).load(Constants.HOST_IMAGE + item.image).into(image_detail)

        btn_addbag.setOnClickListener {
            item.cardCount = 1
            PrefUtils.setBaskets(item)
            Toast.makeText(this, "Product added to bucket", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}