package com.example.androiddevelopment_linkedin.data

import android.content.Context
import android.util.Log
import com.example.androiddevelopment_linkedin.LOG_TAG
import com.example.androiddevelopment_linkedin.utilies.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MonsterRepository {
    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java)

    fun getMonsterData(context: Context):List<Monster>{
        val text = FileHelper.getTextFromAssets(context,"monster_data.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Monster>> =moshi.adapter(listType)
        return adapter.fromJson(text)?: emptyList()
//        for(monster in monsterData?: emptyList()){
//            Log.i(LOG_TAG, "${monster.monsterName} (\$${monster.price})")
//        }

    }
}