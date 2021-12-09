package ru.fefu.activitytracker.lists

import java.time.LocalDateTime

sealed class ListItem {
    data class Item(
        val distance: String,
        val time: String,
        val date: String,
        val activity: String,
        val startTime: Long,
        val endTime: Long,
        val user: String = "",
    ) : ListItem()

    data class Date(
        val date: String,
    ) : ListItem()
}



