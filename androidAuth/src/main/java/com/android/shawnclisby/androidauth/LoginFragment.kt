package com.android.shawnclisby.androidauth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false).apply {

            this.button_login_login.setOnClickListener {
                Toast.makeText(
                    context,
                    "Email:${tie_login_email.text} and Password:${tie_login_password.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()

    }
}