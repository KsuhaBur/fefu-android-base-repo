package ru.fefu.activitytracker.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.BaseFragment
import ru.fefu.activitytracker.lists.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.adapters.ItemAdapter
import ru.fefu.activitytracker.databinding.FragmentMyActivityDetailsBinding
import java.time.Duration
import java.time.LocalDateTime

class MyActivityDetailsFragment(details: ListItem.Item) :
    BaseFragment<FragmentMyActivityDetailsBinding>(R.layout.fragment_my_activity_details) {
    private var _binding: FragmentMyActivityDetailsBinding? = null
    override val binding get() = _binding!!
    private val detail = details

    companion object {
        fun newInstance(info: ListItem.Item): MyActivityDetailsFragment {
            return MyActivityDetailsFragment(info)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textMyDistance.text = detail.distance
        val startTime = "%02d".format(detail.startTime.hour) + ":" + "%02d".format(detail.startTime.minute)
        val endTime = "%02d".format(detail.endTime.hour) + ":" + "%02d".format(detail.endTime.minute)
        binding.textMyStartTime.text = startTime
        binding.textMyFinishTime.text = endTime

        binding.textMyDate.text = detail.date

        binding.toolbarMy.title = detail.activity
        binding.toolbarMy.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        binding.toolbarMy.setOnMenuItemClickListener {
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyActivityDetailsBinding.inflate(inflater, container, false)
        return binding.root    }

}