package com.example.money.data

import com.google.gson.annotations.SerializedName

data class Money(
   val rates : Rates
)
data class Rates(
    @SerializedName("RUB") val rub: Double,
    @SerializedName("EUR") val eur: Double,
    @SerializedName("GBP") val  pound:Double,
    @SerializedName("CZK") val crown: Double,
    @SerializedName("CNY") val yuan: Double
)