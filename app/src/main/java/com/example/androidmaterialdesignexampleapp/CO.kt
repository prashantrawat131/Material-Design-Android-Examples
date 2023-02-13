package com.example.androidmaterialdesignexampleapp

import android.content.Context
import android.util.Log
import android.widget.Toast

class CO {
    companion object {
        fun toast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun log(msg: String) {
            Log.d("tagJi", msg)
        }
    }
}