package com.alpine12.runningapp.repositories

import com.alpine12.runningapp.db.Run
import com.alpine12.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDAO
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurn() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvSpeed() = runDao.getTotalAvgSpeed()

    fun getTotalDistance() = runDao.getTotalDistanceInMeters()

    fun getTotalCaloriesBurn()= runDao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
}