package com.example.money.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.money.R
import com.example.money.data.MoneyRepository
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.coroutines.CoroutineContext

class FirstFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = MoneyRepository()
        when (arguments?.getInt("key") ?: "") {
            1 -> launch {
                val money = repository.getMoney().await()

                loader.visibility = View.GONE
                textAndImage.visibility = View.VISIBLE
                moneyRate.visibility = View.VISIBLE

                money?.let {
                    moneyText.text = getString(R.string.moneyFragmentTitleUsd)
                    moneyImage.setImageResource(R.drawable.usa)
                    moneyRate.text = getString(R.string.money).format(it.rub.toString())
                }
                }
                2  ->
                launch {
                    val money = repository.getMoney().await()

                    loader.visibility = View.GONE
                    textAndImage.visibility = View.VISIBLE
                    moneyRate.visibility = View.VISIBLE

                    val euro = ((1.0 - money!!.eur) + 1) * money.rub
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING

                    money?.let {
                        moneyText.text =getString(R.string.moneyFragmentTitleEuro)
                            moneyImage.setImageResource(R.drawable.europe)
                        moneyRate.text =getString(R.string.money).format(it.rub.toString())
                    }
                }
            3 -> launch {
                val money = repository.getMoney().await()
                loader.visibility = View.GONE
                textAndImage.visibility = View.VISIBLE
                moneyRate.visibility = View.VISIBLE

                money?.let{
                    moneyText.text = getString(R.string.moneyFragmentTitlePound)
                    moneyImage.setImageResource(R.drawable.uk)
                    moneyRate.text = getString(R.string.money).format(it.pound.toString())
                }
            }
            4 -> launch {
                val money = repository.getMoney().await()
                loader.visibility = View.GONE
                textAndImage.visibility = View.VISIBLE
                moneyRate.visibility = View.VISIBLE

                money?.let{
                    moneyText.text = getString(R.string.moneyFragmentTitleCrown)
                    moneyImage.setImageResource(R.drawable.czk)
                    moneyRate.text = getString(R.string.money).format(it.crown.toString())
                }
            }
            5 -> launch {
                val money = repository.getMoney().await()
                loader.visibility = View.GONE
                textAndImage.visibility = View.VISIBLE
                moneyRate.visibility = View.VISIBLE

                money?.let{
                    moneyText.text = getString(R.string.moneyFragmentTitleYuan)
                    moneyImage.setImageResource(R.drawable.china)
                    moneyRate.text = getString(R.string.money).format(it.yuan.toString())
                }
            }


        }


    }
}

