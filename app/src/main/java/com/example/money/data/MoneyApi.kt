package com.example.money.data

import retrofit2.Call
import retrofit2.http.GET

interface MoneyApi {
    @GET("v6/latest")

    fun getMoney() : Call<Money>
}