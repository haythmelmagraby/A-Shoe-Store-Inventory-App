package com.udacity.shoestore.views

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeTextBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.SharedViewModel

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment, container, false
        )

        binding.floatingActionButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        // to connect the fragment with the SharedViewModel
        viewModel = ViewModelProvider(this.requireActivity()).get(SharedViewModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myLinearLayout = view?.findViewById<LinearLayout>(R.id.shoe_tlist_linear_layou_id)
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->
                    myLinearLayout.removeAllViews()
            updateShoeList(newList, myLinearLayout)

        })

    }

    private fun updateShoeList(
        list: MutableList<Shoe>,
        linearLayout: LinearLayout?
    ) {
        list.forEach {
            val binding = DataBindingUtil.inflate<ShoeTextBinding>(
                LayoutInflater.from(requireContext()), R.layout.shoe_text, linearLayout,
                true
            )
            // using kotlin scope function
            with(binding){
                name = it.name
                size = it.size
                company = it.company
                description = it.description
            }
        }
    }


    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment22())
        return true

    }


}
