package com.example.coronaway.view.fragments.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronaway.databinding.LayoutListitemBinding
import com.example.coronaway.view.models.Country

class DashboardAdapter(private var list: MutableList<Country> = mutableListOf()) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>(){

    inner class DashboardViewHolder(private val binding: LayoutListitemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.CountryText.text = country.name
            binding.totalCasesPerCountryText.text = country.confirmed.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = LayoutListitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DashboardViewHolder(binding = binding)
    }

    fun setList(list: List<Country>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}