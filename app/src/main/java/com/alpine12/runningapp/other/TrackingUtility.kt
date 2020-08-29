package com.alpine12.runningapp.other

import android.Manifest.*
import android.content.Context
import android.os.Build
import pub.devrel.easypermissions.EasyPermissions

object TrackingUtility{

    fun hasLocationPermission(context: Context) =
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            EasyPermissions.hasPermissions(
                context,
                permission.ACCESS_FINE_LOCATION,
                permission.ACCESS_COARSE_LOCATION
            )
        }else{
            EasyPermissions.hasPermissions(
                context,
                permission.ACCESS_FINE_LOCATION,
                permission.ACCESS_COARSE_LOCATION,
                permission.ACCESS_BACKGROUND_LOCATION
            )
        }
}