package com.example.mybills.presentation

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mybills.R
import com.example.mybills.databinding.HomeFragmentBinding
import com.example.mybills.presentation.adapter.BillsAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding
    private val billAdapter: BillsAdapter = BillsAdapter()
    private val viewModel: BillViewModel by sharedViewModel()
    private var getProductsJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        setupRecycler()
        setListeners()
        setupObservers()

        return root
    }

    fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getListBills.collectLatest {
                getList()
            }
        }
    }

    fun getList() {
        getProductsJob?.cancel()
        getProductsJob = viewModel.viewModelScope.launch {
            viewModel.getListBills.collectLatest { list ->
                billAdapter.stateRestorationPolicy =
                    RecyclerView.Adapter.StateRestorationPolicy.PREVENT
                billAdapter.submitList(list)
            }
        }
    }

    fun setListeners() {
        binding.addButton.setOnClickListener {
            navigateToAdd()
        }

        billAdapter.setDeleteClickListener { billEntity ->
            viewModel.deleteBill(billEntity)
        }
    }

    fun navigateToAdd() {
        findNavController().navigate(R.id.action_homeFragment_to_addBillFragment)
    }

    fun setupRecycler() {
        binding.recycler.run {
            adapter = billAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}