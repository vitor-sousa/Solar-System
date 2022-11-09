package com.vitorsousa.solarsystem.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vitorsousa.solarsystem.data.CelestialObject
import com.vitorsousa.solarsystem.databinding.ItemCelestialBinding

class CelestialAdapter: RecyclerView.Adapter<CelestialAdapter.CelestialViewHolder>() {

    private val mDiffer = AsyncListDiffer(this, DIFF_UTIL)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelestialViewHolder {
        return CelestialViewHolder(
            ItemCelestialBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CelestialViewHolder, position: Int) {
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun updateList(newList: List<CelestialObject>) {
        mDiffer.submitList(newList)
    }



    inner class CelestialViewHolder(private val binding: ItemCelestialBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(celestialObject: CelestialObject) {
            binding.apply {
                textViewName.text = celestialObject.name
                textViewSize.text = "Diameter: ${celestialObject.size} km"
                textViewGravity.text = "Gravity: ${celestialObject.gravity} m/s²"
                textViewType.text = celestialObject.type.name
                imageViewImage.setImageResource(celestialObject.image)
            }
        }
    }

    object DIFF_UTIL: DiffUtil.ItemCallback<CelestialObject>(){
        override fun areItemsTheSame(oldItem: CelestialObject, newItem: CelestialObject): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CelestialObject, newItem: CelestialObject): Boolean {
            return oldItem == newItem
        }

    }

}