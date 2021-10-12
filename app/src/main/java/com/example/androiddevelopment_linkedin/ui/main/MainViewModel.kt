package com.example.androiddevelopment_linkedin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddevelopment_linkedin.LOG_TAG
import com.example.androiddevelopment_linkedin.data.Monster
import com.example.androiddevelopment_linkedin.data.MonsterRepository
import com.example.androiddevelopment_linkedin.utilies.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MainViewModel(app:Application):AndroidViewModel(app) {

    private val dataRepo =MonsterRepository()

    init {
//        val text1 = FileHelper.getTextFromResources(app,R.raw.monster_data)
//        Log.i(LOG_TAG,text1)
        val monsterData =dataRepo.getMonsterData(app)
        for(monster in monsterData){
            Log.i(LOG_TAG, "${monster.monsterName} (\$${monster.price})")
        }
    }

}
