package com.example.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val logTag = "MainActivity"
    private var time = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w(logTag, "Activity onCreate. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
    }

    override fun onStart() {
        super.onStart()
        Log.w(logTag, "Activity onStart. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
    }

    override fun onRestart() {
        super.onRestart()
        Log.w(logTag, "Activity onRestart. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
    }

    override fun onResume() {
        super.onResume()
        Log.w(logTag, "Activity onResume. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
    }

    override fun onPause() {
        Log.w(logTag, "Activity onPause. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
        super.onPause()
    }

    override fun onStop() {
        Log.w(logTag, "Activity onStop. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
        super.onStop()
    }

    override fun onDestroy() {
        Log.w(logTag, "Activity onDestroy. Duration between phases - "
                + (System.currentTimeMillis() - time) + " milliseconds.")
        time = System.currentTimeMillis()
        super.onDestroy()
    }

    fun onClick(view: View) {
        val buttonName = (view as Button).text
        val label = findViewById<TextView>(R.id.textView)
        val msg = "Button $buttonName was clicked."
        Log.i(logTag, msg)
        label.text = msg
        if(buttonName.equals("About")) {
            createAboutActivity(view)
        }
    }

    private fun createAboutActivity(view: View) {
        val intentAbout = Intent(this, AboutActivity::class.java)
        startActivity(intentAbout)
    }
}