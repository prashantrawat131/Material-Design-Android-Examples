package com.example.androidmaterialdesignexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmaterialdesignexampleapp.databinding.ActivityMaterialToolbarBinding

class MaterialToolbarActivity : AppCompatActivity() {

    lateinit var binding: ActivityMaterialToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar2.setNavigationOnClickListener {
            CO.toast(applicationContext, "Navigation button clicked")
        }

        binding.topAppBar2.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    CO.toast(applicationContext, "Favourite")
                    true
                }
                R.id.search -> {
                    CO.toast(applicationContext, "Search")
                    true
                }
                R.id.more -> {
                    CO.toast(applicationContext, "More")
                    true
                }
                else -> {
                    CO.toast(applicationContext, "Else")
                    true
                }
            }
        }

        setUpListView()
    }

    private fun setUpListView() {
        val list = listOf(
            "Red",
            "Pink",
            "Blue",
            "Violet",
            "Green",
            "Yellow",
            "Purple",
            "Grey",
            "White",
            "Black",
            "Pink",
            "Gold",
            "Silver",
            "Purple",
            "Grey",
            "White",
            "Black",
            "Pink",
            "Gold",
            "Silver"
        )


        val adapter = RecyclerViewAdapter(layoutInflater, applicationContext, list) { position -> }


        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter


    }

}