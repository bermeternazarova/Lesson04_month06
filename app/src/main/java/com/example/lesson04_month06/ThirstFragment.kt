package com.example.lesson04_month06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.lesson04_month06.databinding.FragmentThirstBinding

class ThirstFragment : Fragment() {

    private lateinit var binding: FragmentThirstBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentThirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(requireActivity())[MainViewModel::class.java]
        observers()
    }

    private fun observers() {
        viewModel.mCover.observe(activity as LifecycleOwner){
            binding.textPage3.text=it.toString()
        }
    }
}