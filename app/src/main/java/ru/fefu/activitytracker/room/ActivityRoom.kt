package ru.fefu.activitytracker.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// представление таблицы
@Entity
data class ActivityRoom(
    // id активности
    @PrimaryKey(autoGenerate = true) val id: Int,
    // тип активности
    @ColumnInfo(name = "activity_type") val type: Int,
    // время начала
    @ColumnInfo(name = "start_time") val startTime: Long,
    // время конца
    @ColumnInfo(name = "end_time") val endTime: Long,
    // начальные координаты
    @ColumnInfo(name = "latitude") val latitude: Double,
    // конечные координаты
    @ColumnInfo(name = "longitude") val longitude: Double
)