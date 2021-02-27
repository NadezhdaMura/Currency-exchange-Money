package com.example.money.data

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class MoneyRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

       private val moneyApi = Retrofit.Builder()
           .baseUrl("https://api.exchangerate-api.com")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(MoneyApi::class.java)

    fun getMoney() = async {
        moneyApi.getMoney()
            .execute()
            .body()
            ?.rates
    }

}