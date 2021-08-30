package com.sodiqjon.online_shop.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sodiqjon.online_shop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var navigationController: NavController
private lateinit var listener: NavController.OnDestinationChangedListener

//
//    var offers: List<BaseResponse> = emptyList()
//    var category: List<Posts_model> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController=findNavController(R.id.fragment)
        bottom_navigation.setupWithNavController(navigationController)
      // linear_shape.setBackgroundResource(R.drawable.card_bac)



    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)

        return super.onSupportNavigateUp()
    }




}
