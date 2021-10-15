package com.example.coronaway.view.fragments.map

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.coronaway.R
import com.example.coronaway.databinding.FragmentMapsBinding
import com.example.coronaway.view.fragments.InfoViewModel
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private val viewModel: InfoViewModel by activityViewModels()
    private lateinit var binding: FragmentMapsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callback = OnMapReadyCallback { googleMap ->
            viewModel.country.observe(viewLifecycleOwner) { lan ->
                val arr = lan.data
                for (country in arr) {
                    googleMap.addCircle(
                        CircleOptions()
                            .center(LatLng(country.lat.toDouble(), country.exLong.toDouble()))
                            .fillColor(Color.argb(70, 150, 50, 50))
                            .strokeColor(Color.RED)
                            .strokeWidth(3f)
                            .radius(country.confirmed.toDouble() / 30.0)
                    )
                }
            }
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}