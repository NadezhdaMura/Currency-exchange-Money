package com.example.money.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.money.R
import kotlinx.android.synthetic.main.fragment_navigation.*

class NavigationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val firstFragment = FirstFragment()
        dollarButton.setOnClickListener {
            firstFragment.arguments = Bundle().also {
                it.putInt("key", 1)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, firstFragment)
                ?.addToBackStack((null))
                ?.commit()
        }
        euroButton.setOnClickListener {
            firstFragment.arguments = Bundle().also {
                it.putInt("key", 2)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, firstFragment)
                ?.addToBackStack((null))
                ?.commit()
        }
        poundButton.setOnClickListener {
            firstFragment.arguments = Bundle().also {
                it.putInt("key", 3)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, firstFragment)
                ?.addToBackStack((null))
                ?.commit()
        }
        crownButton.setOnClickListener {
            firstFragment.arguments = Bundle().also {
                it.putInt("key", 4)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, firstFragment)
                ?.addToBackStack((null))
                ?.commit()
        }
        yuanButton.setOnClickListener {
            firstFragment.arguments = Bundle().also {
                it.putInt("key", 5)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, firstFragment)
                ?.addToBackStack((null))
                ?.commit()
        }
    }
}