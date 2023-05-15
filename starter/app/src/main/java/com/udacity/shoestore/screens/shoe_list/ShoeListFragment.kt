package com.udacity.shoestore.screens.shoe_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.Constants.Companion.IS_LOGIN_IN
import com.udacity.shoestore.utils.Constants.Companion.MY_PREFS

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel.shoeList.observe(viewLifecycleOwner) {
            updateShoeList(it)
        }

        setHasOptionsMenu(true)

        val sharedPref = activity?.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref?.getBoolean(IS_LOGIN_IN, false)

        //Check if user do not login yet will navigate to login screen
        if (isLoggedIn == false) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .build()
            findNavController().navigate(
                R.id.action_shoeListFragment_to_loginFragment, null,
                navOptions
            )
        }

        return binding.root
    }

    private fun updateShoeList(shoeList: List<Shoe>) {
        binding.lnlShoeList.apply {
            removeAllViews()
            for (shoe in shoeList) {
                addView(
                    LayoutInflater.from(binding.lnlShoeList.context)
                        .inflate(R.layout.shoe_item, binding.lnlShoeList, false).apply {
                            findViewById<TextView>(R.id.shoe_image)
                            findViewById<TextView>(R.id.shoe_name).text = shoe.name
                            findViewById<TextView>(R.id.shoe_company).text = shoe.company
                            findViewById<TextView>(R.id.shoe_size).text = shoe.size.toString()
                            findViewById<TextView>(R.id.shoe_description).text = shoe.description
                        }
                )
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
