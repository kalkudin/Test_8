package com.example.test_8.presentation.adapter

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_8.databinding.DrawerItemLayoutBinding
import com.example.test_8.presentation.model.DrawerItem

class DrawerItemRecyclerAdapter() :
    ListAdapter<DrawerItem, DrawerItemRecyclerAdapter.ViewHolder>(DrawerItemDiffCallback()) {

    inner class ViewHolder(private val binding: DrawerItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DrawerItem) {
            with(binding) {
                icIcon.setImageResource(item.iconResId)
                tvDescription.text = item.description

                item.notification?.let {
                    tvNotification.visibility = View.VISIBLE
                    tvNotification.text = it.toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DrawerItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DrawerItemDiffCallback : DiffUtil.ItemCallback<DrawerItem>() {
        override fun areItemsTheSame(oldItem: DrawerItem, newItem: DrawerItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DrawerItem, newItem: DrawerItem): Boolean {
            return oldItem == newItem
        }
    }
}