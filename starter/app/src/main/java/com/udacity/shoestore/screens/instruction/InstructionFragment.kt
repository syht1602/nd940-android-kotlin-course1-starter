package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    private lateinit var viewModel: InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        viewModel = ViewModelProvider(this)[InstructionViewModel::class.java]
        binding.instructionViewModel = viewModel
        viewModel.isNextButtonClick.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
                viewModel.resetButtonState()
            }
        }
        return binding.root
    }
}
