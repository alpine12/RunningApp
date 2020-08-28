package com.alpine12.runningapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alpine12.runningapp.R
import com.alpine12.runningapp.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var runDao : RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}