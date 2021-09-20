package com.example.coronaway.view.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coronaway.databinding.FragmentDashboardBinding
import com.example.coronaway.view.fragments.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: InfoViewModel by activityViewModels()
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

        viewModel.data.observe(viewLifecycleOwner, {
            binding.totalCasesText.text = it.data.totalConfirmed.toString()
            binding.totalDeathText.text = it.data.totalDeaths.toString()
            binding.totalRecoveredText.text = it.data.totalRecovered.toString()

        })

        viewModel.country.observe(viewLifecycleOwner, {
            adapter.setList(it.data)
        })
    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

}