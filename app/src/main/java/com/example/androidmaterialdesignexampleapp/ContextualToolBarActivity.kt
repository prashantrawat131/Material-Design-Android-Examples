package com.example.androidmaterialdesignexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmaterialdesignexampleapp.databinding.ActivityContextualToolBarBinding

class ContextualToolBarActivity : AppCompatActivity() {


    lateinit var binding:ActivityContextualToolBarBinding
    lateinit var callback: ActionMode.Callback
    var selectedItemsList = arrayListOf<Int>()
    lateinit var actionMode: ActionMode

    var newCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContextualToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpContextualToolBar()

        setUpRecyclerView()
    }


    private fun setUpContextualToolBar() {
        callback = object : ActionMode.Callback {

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.contextual_action_bar, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.share -> {
                        // Handle share icon press
                        CO.toast(applicationContext, "Share")
                        true
                    }
                    R.id.delete -> {
                        // Handle delete icon press
                        CO.toast(applicationContext, "Delete")
                        true
                    }
                    R.id.more -> {
                        // Handle more item (inside overflow menu) press
                        CO.toast(applicationContext, "More")
                        true
                    }
                    else -> false
                }
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
            }
        }

    }

    private fun setUpRecyclerView() {
        val list = listOf(
            "Red", "Pink", "Blue", "Violet", "Green", "Yellow",
            "Purple", "Grey", "White", "Black", "Pink", "Gold", "Silver",
            "Purple", "Grey", "White", "Black", "Pink", "Gold", "Silver"
        )


        val adapter = RecyclerViewAdapter(layoutInflater, applicationContext, list) { position ->

//            val contains = contains(position)

            CO.log("List contains: ${selectedItemsList.contains(position)}  position: $position")

            if (selectedItemsList.contains(position)) {
                newCount--
                if (newCount == 0) {
                    actionMode.finish()
                }
            } else {
                newCount++
                selectedItemsList.add(position)
                if (newCount == 1) {
                    actionMode = startSupportActionMode(callback)!!
                }
            }

            actionMode.title = "$newCount selected"

//            CO.log("New count: $newCount")
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter


        /* val adapter = ArrayAdapter(
             applicationContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
             list
         )

         binding.listView.adapter = adapter

         binding.listView.setOnItemClickListener(object:AdapterView.OnItemClickListener{
             override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                 val actionMode = startSupportActionMode(callback)
                 actionMode?.title = "1 selected"
             }
         })*/
    }

}