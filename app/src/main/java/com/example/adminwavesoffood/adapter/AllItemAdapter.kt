package com.example.adminwavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwavesoffood.databinding.ItemItemBinding


class AllItemAdapter(private val MenuItemName:MutableList<String>,private val MenuItemPrice:MutableList<String>,private val MenuItemImage:MutableList<Int>) :
    RecyclerView.Adapter<AllItemAdapter.AddItemViewHolder>() {

    private val itemQuantities = IntArray(MenuItemName .size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemName.size

    inner class AddItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                foodNameTextView.text = MenuItemName[position]
                fooditemPrice.text = MenuItemPrice[position]
                foodImageView.setImageResource(MenuItemImage[position])
                foodQuantity.text = quantity.toString()

                binding.minusButton.setOnClickListener {
                    decreaseQuantity(position)

                }
                binding.plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                binding.deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }

                }
            }

        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.foodQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.foodQuantity.text = itemQuantities[position].toString()
            }

        }

        private fun deleteItem(position: Int) {
            MenuItemName.removeAt(position)
            MenuItemPrice.removeAt(position)
            MenuItemImage.removeAt(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position, MenuItemName.size)
        }

    }
}
