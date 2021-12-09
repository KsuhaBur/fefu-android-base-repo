package ru.fefu.activitytracker.lists

class UsersListRepository {
    private val usersListItem = listOf(
        ListItem.Date(
            date = "Вчера",
        ),
        ListItem.Item(
            distance = "14.32 км",
            time = "2 часа 46 минут",
            activity = "Серфинг",
            date = "14 часов назад",
            startTime = 541646849846546,
            endTime = 155415416565,
            user = "@van_darkholme",
        ),
        ListItem.Item(
            distance = "228 м",
            time = "14 часов 48 минут",
            activity = "Качели",
            date = "14 часов назад",
            startTime = 521541454546454645,
            endTime = 5148498484898,
            user = "@techniquepasha",
        ),
        ListItem.Item(
            distance = "10 км",
            time = "1 час 10 минут",
            activity = "Езда на кадилак",
            date = "14 часов назад",
            startTime = 151514654645,
            endTime = 55444545468,
            user = "@morgen_shtern",
        ),
    )

    fun getItem() : List<ListItem> = usersListItem
}