package com.alpine12.runningapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleService
import com.alpine12.runningapp.R
import com.alpine12.runningapp.other.Constant.ACTION_PAUSE_SERVICE
import com.alpine12.runningapp.other.Constant.ACTION_SHOW_TRACKING_FRAGMENT
import com.alpine12.runningapp.other.Constant.ACTION_START_OR_RESUME_SERVICE
import com.alpine12.runningapp.other.Constant.ACTION_STOP_SERVICE
import com.alpine12.runningapp.other.Constant.NOTIFICATION_CHANEL_ID
import com.alpine12.runningapp.other.Constant.NOTIFICATION_CHANEL_NAME
import com.alpine12.runningapp.other.Constant.NOTIFICATION_CHANNEL_ID
import com.alpine12.runningapp.ui.MainActivity
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun =  true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("Started or resume service")
                    if (isFirstRun){
                        startForeGroundService()
                        isFirstRun = false
                    }else{
                        Timber.d("Resuming Service . . . ")
                    }

                }

                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Pause service")
                }

                ACTION_STOP_SERVICE -> {
                    Timber.d("Stop service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForeGroundService() {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(
            this, NOTIFICATION_CHANNEL_ID
        )
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_baseline_directions_run_24)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_CHANEL_ID, notificationBuilder.build())

    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val chanel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANEL_NAME,
            NotificationManager.IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(chanel)
    }
}