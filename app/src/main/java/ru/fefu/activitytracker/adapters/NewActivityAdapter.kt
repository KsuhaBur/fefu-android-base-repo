package ru.fefu.activitytracker.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ItemActivityTypeBinding
import ru.fefu.activitytracker.lists.ActivityType

class NewActivityAdapter(items: List<ActivityType>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var selected = -1

    private val list = items.toMutableList()

    private var itemClickListener: (Int) -> Unit = {}

    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity_type, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int = 3


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemActivityTypeBinding.bind(itemView)

        @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
        fun bind(model: ActivityType) = with(binding) {
            textActivityType.text = model.activity
            itemView.isSelected = model.isSelected

            if (itemView.isSelected) {
                itemView.setBackgroundColor(R.drawable.border_selected)
            } else {
                itemView.setBackgroundColor(R.drawable.border)
            }
            itemView.setOnClickListener {
                list[adapterPosition].isSelected = true
                if (selected != -1 && selected != adapterPosition) {
                    list[selected].isSelected = false
                }
                selected = adapterPosition
                notifyDataSetChanged()
            }
        }

//        init {
//            item.setOnClickListener {
//                val position = adapterPosition
//                if (position != RecyclerView.NO_POSITION)
//                    itemClickListener.invoke(position)
//            }
//        }
    }
}

