package com.example.coronaway.view.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coronaway.databinding.FragmentDashboardBinding
import com.example.coronaway.view.fragments.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: InfoViewModel by viewModels()
    private lateinit var binding: FragmentDashboardBinding
    private val adapter: DashboardAdapter = DashboardAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        binding.apply {
            recyclerView.apply {
                setupAdapter()
            }
        }

        viewModel.information.observe(viewLifecycleOwner, {
            binding.totalCasesText.text = it.data?.china?.totalConfirmed?.toString()
            binding.lastUpdateText.text = it.data?.lastCheckTimeText
            binding.totalDeathText.text = it.data?.china?.totalDeaths.toString()
            binding.totalRecoveredText.text = it.data?.china?.totalRecovered?.toString()
            it.data?.china?.let { it1 -> adapter.setList(it1.countries) }
        })

    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

}