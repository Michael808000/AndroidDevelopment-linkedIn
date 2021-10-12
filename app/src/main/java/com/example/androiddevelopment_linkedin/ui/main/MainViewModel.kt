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

    private val dataRepo =MonsterRepository(app)
    val monsterData = dataRepo.monsterData

}
