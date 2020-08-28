package com.alpine12.runningapp.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alpine12.runningapp.R
import com.alpine12.runningapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run){

    private val viewModel : MainViewModel by viewModels()

}