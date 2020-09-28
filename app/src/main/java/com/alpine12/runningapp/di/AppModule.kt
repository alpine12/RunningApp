package com.alpine12.runningapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.alpine12.runningapp.db.RunningDatabase
import com.alpine12.runningapp.other.Constant
import com.alpine12.runningapp.other.Constant.RUNNING_DATABASE_NAME
import com.alpine12.runningapp.other.Constant.SHARED_PREFERENCES_NAMES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            app,
            RunningDatabase::class.java,
            RUNNING_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun runDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAMES, Context.MODE_PRIVATE)


    @Singleton
    @Provides
    fun provideName(sharedPref : SharedPreferences) = sharedPref.getString(Constant.KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPref : SharedPreferences) = sharedPref.getFloat(Constant.KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref : SharedPreferences) = sharedPref.getBoolean(Constant.KEY_FIRST_TIME_TOGGLE, true)

}