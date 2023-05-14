package com.udacity.shoestore.screens.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe_list.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeDetailViewModel
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.shoeDetailViewModel = viewModel

        viewModel.isSave.observe(viewLifecycleOwner) { isSave ->
            if (isSave) {
                shoeListViewModel.addShoe(
                    Shoe(
                        viewModel.shoeName,
                        viewModel.shoeCompany,
                        viewModel.shoeSize.toDoubleOrNull(),
                        viewModel.shoeDescription
                    )
                )
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Please input all * field", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        viewModel.isCancel.observe(viewLifecycleOwner) {
            if (it) findNavController().navigateUp()
        }

        return binding.root
    }
}
