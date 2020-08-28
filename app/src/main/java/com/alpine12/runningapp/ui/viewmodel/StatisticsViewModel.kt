package com.alpine12.runningapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.alpine12.runningapp.repositories.MainRepository

class StatisticsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
}