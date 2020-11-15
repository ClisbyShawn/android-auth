package com.android.shawnclisby.androidlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.shawnclisby.androidauth.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_container, LoginFragment.newInstance())
            .commit()

    }
}