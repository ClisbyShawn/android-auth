package com.android.shawnclisby.androidlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.shawnclisby.androidauth.viewModels.AuthViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var authViewModel: AuthViewModel

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel = ViewModelProvider(requireActivity())
            .get(AuthViewModel::class.java)

        authViewModel.session.observe(viewLifecycleOwner) {
            tv_home_welcome.text = "Welcome ${it?.userFirstName}"
        }

        btn_home_logout.setOnClickListener {
            authViewModel.logout()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_main_container, LoginFragment.newInstance())
                .commit()
        }
    }
}