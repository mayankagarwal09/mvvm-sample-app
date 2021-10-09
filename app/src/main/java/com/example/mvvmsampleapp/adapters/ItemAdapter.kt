package com.example.mvvmsampleapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsampleapp.databinding.GridItemRowBinding
import com.example.mvvmsampleapp.databinding.LinearItemRowBinding
import com.example.mvvmsampleapp.models.Item
import javax.inject.Inject

class ItemAdapter @Inject constructor(private val layoutManager: RecyclerView.LayoutManager) :
    ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent, layoutManager)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ItemViewHolder private constructor(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            when (binding) {
                is GridItemRowBinding -> binding.item = item
                is LinearItemRowBinding -> binding.item = item
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, layoutManager: RecyclerView.LayoutManager): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    when (layoutManager) {
                        is GridLayoutManager -> GridItemRowBinding.inflate(
                            layoutInflater,
                            parent,
                            false
                        )
                        else -> LinearItemRowBinding.inflate(layoutInflater, parent, false)
                    }
                return ItemViewHolder(binding)
            }
        }
    }
}

class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}