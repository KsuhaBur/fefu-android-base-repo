package ru.fefu.activitytracker.tracker

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.App
import ru.fefu.activitytracker.BaseFragment
import ru.fefu.activitytracker.adapters.ItemAdapter
import ru.fefu.activitytracker.lists.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentMyActivityBinding
import ru.fefu.activitytracker.lists.MyListRepository
import ru.fefu.activitytracker.room.ActivityDataBase
import ru.fefu.activitytracker.room.ActivityRoom

class MyActivityFragment :
    BaseFragment<FragmentMyActivityBinding>(R.layout.fragment_my_activity) {

    private val listRepository = MyListRepository()
    private val adapterItems = ItemAdapter(listRepository.getItem())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rcView) {
            adapter = adapterItems
            layoutManager = LinearLayoutManager(requireContext())
        }

//        App.INSTANCE.db.activityDao().insert (
//            ActivityRoom (
//                0,
//                1,
//                startDate,
//                endDate,
//                123.0,
//                131.0
//            )
//        )

        adapterItems.setItemClickListener {
            val manager = activity?.supportFragmentManager?.findFragmentByTag("activityFragment")?.childFragmentManager
            manager?.beginTransaction()?.apply {
                manager.fragments.forEach(::hide)
                replace(
                    R.id.activity_fragment_switch_container,
                    MyActivityDetailsFragment.newInstance(listRepository.getItem()[it] as ListItem.Item)
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}