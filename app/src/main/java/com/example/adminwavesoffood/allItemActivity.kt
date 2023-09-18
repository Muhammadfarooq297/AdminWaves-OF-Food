package com.example.adminwavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwavesoffood.adapter.AllItemAdapter
import com.example.adminwavesoffood.databinding.ActivityAllItemBinding

class allItemActivity : AppCompatActivity() {
    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val menuFoodNames= listOf("Burger","Sandwich","Momo","Item","Sandwich","Momo")
        val menuItemPrice= listOf("$5","$6","$7","$8","$9","$10")
        val menuImage= listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu5,R.drawable.menu6)
        val adapter=AllItemAdapter(ArrayList(menuFoodNames),ArrayList(menuItemPrice),ArrayList(menuImage))
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.menuRecyclerView.adapter=adapter
    }
}