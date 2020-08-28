package com.alpine12.runningapp.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alpine12.runningapp.R
import com.alpine12.runningapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking){

    private val viewModel : MainViewModel by viewModels()
}