package com.example.androiddevelopment_linkedin.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.util.LogPrinter
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.androiddevelopment_linkedin.LOG_TAG
import com.example.androiddevelopment_linkedin.WEB_SERVICE_URL
import com.example.androiddevelopment_linkedin.utilies.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MonsterRepository(val app:Application) {

    val monsterData = MutableLiveData<List<Monster>>()
    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java)
    init {
        //getMonsterData()
        //Log.i(LOG_TAG, "Network available: ${networkAvailable()}")
      CoroutineScope(Dispatchers.IO).launch {
          callWebService()
      }

    }

    fun getMonsterData(){
        val text = FileHelper.getTextFromAssets(app,"monster_data.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Monster>> =moshi.adapter(listType)
        monsterData.value =  adapter.fromJson(text)?: emptyList()

    }
    @WorkerThread
    suspend fun callWebService(){
        if(networkAvailable()){
            val retrofit =Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service =retrofit.create(MonsterService::class.java)
            val serviceData =service.getMonsterData().body()?: emptyList()
            monsterData.postValue(serviceData)
        }


    }

    private fun networkAvailable() :Boolean{
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val networkInfo =connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?:false

    }
}