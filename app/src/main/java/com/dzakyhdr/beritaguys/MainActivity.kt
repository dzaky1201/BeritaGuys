package com.dzakyhdr.beritaguys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dzakyhdr.beritaguys.databinding.ActivityMainBinding
import com.dzakyhdr.beritaguys.presentation.NewsAdapter
import com.dzakyhdr.beritaguys.presentation.viewmodel.NewsViewModel
import com.dzakyhdr.beritaguys.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var factory: NewsViewModelFactory
    @Inject lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragment)
        binding.bottomNav.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)
    }
}