package com.udacity.shoestore.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding
import com.udacity.shoestore.viewmodels.SharedViewModel

class ShoeDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: ShoeDetailsFragmentBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.shoe_details_fragment, container,
                false
            )
        binding.shoeDetailCancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeDetailsFragmentDirections
                .actionShoeDetailsFragmentToShoeListFragment())
        )
        //use ktx library
        val viewModel:SharedViewModel by activityViewModels<SharedViewModel>()
        binding.sharedviewmodel = viewModel

        viewModel.savedDetails.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(
                    ShoeDetailsFragmentDirections
                        .actionShoeDetailsFragmentToShoeListFragment()
                )
                viewModel.afterSavedDone()
            }
        })

        return binding.root
    }
}