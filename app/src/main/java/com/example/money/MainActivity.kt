package com.example.money

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.money.ui.FirstFragment
import com.example.money.ui.NavigationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()
                .add(R.id.fragmentContainer,
                    NavigationFragment())
                .commit()
    }
}