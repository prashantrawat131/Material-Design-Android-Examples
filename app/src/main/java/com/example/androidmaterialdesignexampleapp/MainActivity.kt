package com.example.androidmaterialdesignexampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.core.app.ActivityCompat
import com.example.androidmaterialdesignexampleapp.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.snackBarButton.setOnClickListener {
            Snackbar.make(binding.root, "Hi there, this is a snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Ok, got it") {
                    CO.toast(applicationContext, "Thank god!!!")
                }
                .show()
        }

        setUpChips()


/*
        binding.chip.setOnClickListener {
            CO.toast(applicationContext, "Chip clicked")
        }

        binding.chip.setOnCloseIconClickListener {
            CO.toast(applicationContext, "Close icon clicked")
        }

        binding.chip.setOnCheckedChangeListener { p0, p1 ->
            CO.toast(applicationContext, "Check changed")
        }*/
//        startActivity(Intent(this, BackDropActivity::class.java))
    }

    private fun setUpChips() {
        for (x in 1..10) {
            val chip = Chip(this)
            chip.text = "Chip $x"
            chip.isCloseIconVisible = true
            chip.chipIcon = ActivityCompat.getDrawable(
                applicationContext,
                R.drawable.baseline_favorite_border_24
            )

            chip.setOnClickListener {
                CO.toast(applicationContext, "Chip clicked $x")
            }

            chip.setOnCloseIconClickListener {
                CO.toast(applicationContext, "Close icon clicked $x")
                binding.chipGroup.removeView(it)
            }

            chip.setOnCheckedChangeListener { p0, p1 ->
                CO.toast(applicationContext, "Check changed $x")
            }

            binding.chipGroup.addView(chip)
        }
    }
}