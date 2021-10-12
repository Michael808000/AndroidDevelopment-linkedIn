package com.example.androiddevelopment_linkedin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddevelopment_linkedin.LOG_TAG
import com.example.androiddevelopment_linkedin.data.Monster
import com.example.androiddevelopment_linkedin.utilies.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MainViewModel(app:Application):AndroidViewModel(app) {

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java)

    init {
//        val text1 = FileHelper.getTextFromResources(app,R.raw.monster_data)
//        Log.i(LOG_TAG,text1)
        val text = FileHelper.getTextFromAssets(app,"monster_data.json")
       parseText(text)
    }
    fun parseText(text:String){
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Monster>> =moshi.adapter(listType)
        val  monsterData = adapter.fromJson(text)
        for(monster in monsterData?: emptyList()){
            Log.i(LOG_TAG, "${monster.monsterName} (\$${monster.price})")
        }

    }

}
