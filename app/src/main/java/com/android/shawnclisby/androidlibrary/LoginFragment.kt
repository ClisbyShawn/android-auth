package com.android.shawnclisby.androidlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel.AuthEvent.LoginError
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel.AuthEvent.LoginSuccess
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.flow.collect

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

        authViewModel = ViewModelProvider(requireActivity())
            .get(AuthViewModel::class.java)

        lifecycleScope.launchWhenStarted {
            authViewModel.authFlow.collect { status ->
                when (status) {
                    is LoginSuccess -> {
                        authViewModel.me()
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main_container, HomeFragment.newInstance()).commit()
                    }
                    is LoginError -> Toast.makeText(
                        requireContext(),
                        status.errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

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