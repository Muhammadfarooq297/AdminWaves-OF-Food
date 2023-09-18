package com.example.adminwavesoffood

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.adminwavesoffood.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {
    private val binding:ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.selectImage.setOnClickListener {
           pickimage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        }
        binding.backButton.setOnClickListener {
            finish()
        }

    }
    val pickimage= registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri->
        if(uri!=null)
        {
            binding.selectedImage.setImageURI(uri)
        }
    }

}