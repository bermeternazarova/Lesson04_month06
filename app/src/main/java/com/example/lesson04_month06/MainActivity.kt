package com.example.lesson04_month06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.lesson04_month06.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: OnBoardAdapter
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        initView()
    }

    private fun initView() {
        adapter= OnBoardAdapter(this)
        binding.viewPager2.adapter=adapter
        tabLayout=binding.tabLayout

        TabLayoutMediator(binding.tabLayout,binding.viewPager2){tab,position ->
            when(position){
                0->tab.text="Fragment 1"
                    1->tab.text="Fragment 2"
                2->tab.text="Fragment 3"
            }
        }.attach()
    }
}