package ru.fefu.activitytracker.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ActivityRoom::class], version = 1)
abstract class ActivityDataBase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}