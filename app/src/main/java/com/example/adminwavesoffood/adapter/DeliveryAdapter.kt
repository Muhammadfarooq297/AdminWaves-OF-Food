package com.example.adminwavesoffood.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwavesoffood.databinding.DeliveryItemBinding

class DeliveryAdapter(private val customerNames:ArrayList<String>,private val moneyStatus:ArrayList<String>):RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding=DeliveryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int =customerNames.size

   inner class DeliveryViewHolder(private val binding:DeliveryItemBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind() {
           binding.apply {
                 customerName.text=customerNames[position]
                 statusMoney.text=moneyStatus[position]
                 val colorMap= mapOf("received" to Color.GREEN,"notReceived" to Color.RED,"pending" to Color.GRAY)
                 statusMoney.setTextColor(colorMap[moneyStatus[position]]?:Color.BLACK)
                 statusColor.backgroundTintList= ColorStateList.valueOf(colorMap[moneyStatus[position]]?:Color.GRAY)

           }
       }
       }

   }


