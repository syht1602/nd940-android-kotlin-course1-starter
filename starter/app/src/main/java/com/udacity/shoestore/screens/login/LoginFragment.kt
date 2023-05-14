package com.udacity.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.utils.Constants
import timber.log.Timber

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.loginViewModel = viewModel
        viewModel.isLoginSuccess.observe(viewLifecycleOwner) { success ->
            Timber.i("Is logged in : $success")
            if (success == true) {
                val sharedPref =
                    activity?.getSharedPreferences(Constants.MY_PREFS, Context.MODE_PRIVATE)
                sharedPref?.edit()?.putBoolean(Constants.IS_LOGIN_IN, true)?.apply()
                Toast.makeText(activity, "Login successfully!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.resetLoginState()
            } else if (success == false) {
                Toast.makeText(activity, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}
