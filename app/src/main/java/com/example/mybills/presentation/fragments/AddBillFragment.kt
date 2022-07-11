package com.example.mybills.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mybills.R
import com.example.mybills.databinding.ActivityMainBinding
import com.example.mybills.databinding.AddBillFragmentBinding
import com.example.mybills.presentation.BillViewModel
import com.example.mybills.presentation.adapter.BillsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddBillFragment : Fragment() {

    private lateinit var binding: AddBillFragmentBinding
    private lateinit var adapter: BillsAdapter
    private val viewModel: BillViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = AddBillFragmentBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        adapter = BillsAdapter()

        buttonCheckListener()

        return root
    }

    fun buttonCheckListener() {
        binding.checkButton.setOnClickListener {
            viewModel.addNewInput(
                binding.name.editText?.text.toString(),
                binding.dueDate.editText?.text.toString(),
                binding.value.editText?.text.toString()
            )

            buttonNavigateTo()
        }

    }

    fun buttonNavigateTo() {
        findNavController().navigate(R.id.action_addBillFragment_to_homeFragment)
    }
}