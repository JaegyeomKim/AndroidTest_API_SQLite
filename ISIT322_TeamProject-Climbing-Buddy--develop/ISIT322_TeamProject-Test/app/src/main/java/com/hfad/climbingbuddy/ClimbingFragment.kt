package com.hfad.climbingbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hfad.climbingbuddy.databinding.FragmentClimbingBinding


class ClimbingFragment : Fragment() {

    private var _binding: FragmentClimbingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClimbingBinding.inflate(inflater, container, false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val dao = ClimbingDatabase.getInstance(application).climbingDao
        val viewModelFactory = ClimbingModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ClimbingViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}