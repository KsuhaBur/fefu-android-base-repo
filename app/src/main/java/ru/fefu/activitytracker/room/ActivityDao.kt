package ru.fefu.activitytracker.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// запросы в таблицу
@Dao
public interface ActivityDao {

    // выборка всех полей таблицы
    @Query("SELECT * FROM ActivityRoom ORDER BY end_time DESC")
    fun getAll(): LiveData<List<ActivityRoom>>

    // вставка нового элемента в таблицу
    @Insert
    fun insert(activity: ActivityRoom)

    // удаление элемента из таблицы
    @Delete
    fun delete(activity: ActivityRoom)
}
