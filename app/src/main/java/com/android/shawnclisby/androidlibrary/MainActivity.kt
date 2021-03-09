package com.android.shawnclisby.androidlibrary

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_container, SplashFragment.newInstance())
            .commit()

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.me()

        var fragment: Fragment = LoginFragment.newInstance()

        authViewModel.session.observe(this) { session ->
            session?.let {
                fragment = HomeFragment.newInstance()
            }
        }

        Handler().postDelayed({
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_main_container, fragment)
                .commit()
        }, 3000)
    }
}