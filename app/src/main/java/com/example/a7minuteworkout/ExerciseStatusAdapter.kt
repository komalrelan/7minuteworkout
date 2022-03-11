package com.example.a7minuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.databinding.ItemExercisestatusBinding
import java.util.*

class ExerciseStatusAdapter (val items : ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExercisestatusBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model: ExerciseModel = items[position]

        holder.tvItem.text = model.getId().toString()
        when {
            model.getIsSelected() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.item_circular_thin_color_accent_border
                    )
                holder.tvItem.setTextColor(Color.parseColor("#212121")) // Parse the color string, and return the corresponding color-int.
            }
            model.getIsCompleted() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_accent_background)
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }
            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_gray_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding: ItemExercisestatusBinding) : RecyclerView.ViewHolder(binding.root) {
        // Holds the TextView that will add each item to
        val tvItem = binding.tvitem
    }
}
