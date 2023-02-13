package com.example.androidmaterialdesignexampleapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaterialdesignexampleapp.databinding.RecycleItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RecyclerViewAdapter(
    private val layoutInflater: LayoutInflater,
    private val context: Context,
    private val list: List<String>,
    val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val b = RecycleItemBinding.inflate(
            layoutInflater,
            parent, false
        )
        return RecyclerViewHolder(b)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.b.fruitNameTv.text = list[position]

        holder.b.root.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RecyclerViewHolder(private val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val b: RecycleItemBinding = binding
    }
}

