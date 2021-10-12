package com.example.androiddevelopment_linkedin.ui.main

import android.app.Application
import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.AndroidViewModel
import com.example.androiddevelopment_linkedin.LOG_TAG
import com.example.androiddevelopment_linkedin.R
import com.example.androiddevelopment_linkedin.utilies.FileHelper

class MainViewModel(app:Application):AndroidViewModel(app) {
    init {
        //val text1 = FileHelper.getTextFromResources(app,R.raw.monster_data)
        //Log.i(LOG_TAG,text1)
        val text = FileHelper.getTextFromAssets(app,"monster_data.json")
        Log.i("MonsterLogging2",text)

    }

}
