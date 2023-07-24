package com.remcos.activityplugin

import android.content.Intent
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ConnectSessionActivity : AppCompatActivity() {   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent().also {
            it.putExtra("resultMessage", "This is a test.")
        }
        setResult(Activity.RESULT_OK, intent)
        finish()      
    }
}