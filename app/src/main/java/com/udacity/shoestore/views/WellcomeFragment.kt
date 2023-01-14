package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WellcomeFragmentBinding

class WellcomeFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // initialize binding in concise way
        val binding = WellcomeFragmentBinding.inflate(inflater,container,false)
        binding.wellcomeButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_wellcomeFragment_to_instructionsFragment2)
        )
        return binding.root
    }
}