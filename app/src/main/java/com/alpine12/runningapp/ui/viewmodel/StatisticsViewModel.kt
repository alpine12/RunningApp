package com.alpine12.runningapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.alpine12.runningapp.repositories.MainRepository

class StatisticsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    val totalTimeRun = mainRepository.getTotalTimeInMillis()
    val totalDistance = mainRepository.getTotalDistance()
    val totalCaloriesBurn = mainRepository.getTotalCaloriesBurn()
    val totalAvgSpeed = mainRepository.getTotalAvSpeed()

    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()

}