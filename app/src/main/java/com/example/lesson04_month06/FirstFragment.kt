package com.example.lesson04_month06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.lesson04_month06.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(requireActivity())[MainViewModel::class.java]
        initListeners()
    }

    private fun initListeners() {
        binding.btnIncrease.setOnClickListener {
            viewModel.onIncrement()
        }
        binding.btnDecrease.setOnClickListener {
            viewModel.onReduce()
        }
        viewModel.mCounter.observe(activity as LifecycleOwner){
            binding.textViewPage.text=it.toString()
        }
    }
}