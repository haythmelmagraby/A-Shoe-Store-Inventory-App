package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding:InstructionsFragmentBinding = DataBindingUtil.inflate(inflater
            , R.layout.instructions_fragment,container,false)
        binding.instructionButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment2_to_shoeListFragment)
        )
        return binding.root
    }
}