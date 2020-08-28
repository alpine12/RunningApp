package com.alpine12.runningapp.di

import android.content.Context
import androidx.room.Room
import com.alpine12.runningapp.db.RunningDatabase
import com.alpine12.runningapp.other.Constant.RUNNING_DATABASE_NAME
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
    fun runDao(db : RunningDatabase) = db.getRunDao()

}