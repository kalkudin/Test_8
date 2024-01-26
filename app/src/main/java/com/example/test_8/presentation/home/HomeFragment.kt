package com.example.test_8.presentation.home

import com.example.test_8.databinding.FragmentHomeLayoutBinding
import com.example.test_8.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeLayoutBinding>(FragmentHomeLayoutBinding::inflate) {
    override fun bindViewActionListeners() {
    }

    override fun bindObservers() {
    }
}