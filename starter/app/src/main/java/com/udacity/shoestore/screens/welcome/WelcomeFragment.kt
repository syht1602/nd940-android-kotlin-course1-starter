package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import timber.log.Timber

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.i("View created !")
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_welcome,
                container,
                false
            )
        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        binding.welcomeViewModel = viewModel
        viewModel.isNextButtonClick.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
                viewModel.resetButtonState()
            }
        }
        return binding.root
    }
}
