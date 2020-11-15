package com.android.shawnclisby.androidauth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var authViewModel: AuthViewModel

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)

        authViewModel.token.observe(this, { token ->
            Toast.makeText(requireContext(), token, Toast.LENGTH_LONG).show()
        })

        button_login_login.setOnClickListener {
            authViewModel.login(
                mapOf(
                    "email" to tie_login_email.text.toString().trim(),
                    "password" to tie_login_password.text.toString().trim()
                )
            )
        }
    }
}