package com.sodiqjon.online_shop

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.orhanobut.hawk.Hawk
import com.sodiqjon.online_shop.db.AppDataBase

class App:MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        Hawk.init(this).build()
        AppDataBase.initDatabase(this)

    }
}