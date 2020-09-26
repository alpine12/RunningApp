package com.alpine12.runningapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpine12.runningapp.db.Run
import com.alpine12.runningapp.repositories.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    fun insertRun(run : Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }
}