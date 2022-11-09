package com.vitorsousa.solarsystem.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitorsousa.solarsystem.data.CelestialObject
import com.vitorsousa.solarsystem.databinding.ItemCelestialBinding

class CelestialAdapter: RecyclerView.Adapter<CelestialAdapter.CelestialViewHolder>() {

    private val celestialObjectList = mutableListOf<CelestialObject>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelestialViewHolder {
        return CelestialViewHolder(
            ItemCelestialBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CelestialViewHolder, position: Int) {
        holder.bind(celestialObjectList[position])
    }

    override fun getItemCount(): Int {
        return celestialObjectList.size
    }

    fun updateList(newList: List<CelestialObject>) {
        celestialObjectList.clear()
        celestialObjectList.addAll(newList)
        notifyDataSetChanged()
    }



    inner class CelestialViewHolder(private val binding: ItemCelestialBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(celestialObject: CelestialObject) {
            binding.apply {
                textViewName.text = celestialObject.name
                textViewSize.text = "Diameter: ${celestialObject.size} km"
                textViewGravity.text = "Gravity: ${celestialObject.gravity} m/s²"
                textViewType.text = "Type: ${celestialObject.type.name}"
                imageViewImage.setImageResource(celestialObject.image)
            }
        }
    }

}