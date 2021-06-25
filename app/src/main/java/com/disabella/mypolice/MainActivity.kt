package com.disabella.mypolice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<View>(R.id.calendarView)
        calendarView.setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        }
        val settingsView = findViewById<View>(R.id.settingsView)
        settingsView.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        val mainLayout = findViewById<View>(R.id.mainLayout)
        val valueLayout = intent.getStringExtra(EXTRA_MESSAGE)
        if (valueLayout == "BLACK") {
            mainLayout.setBackgroundColor(Color.BLACK)
        } else if (valueLayout == "WHITE") {
            mainLayout.setBackgroundColor(Color.WHITE)
        }

        val emailView = findViewById<View>(R.id.emailView)
        emailView.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }

        val scanView = findViewById<View>(R.id.scanView)
        scanView.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
        }

        val cameraView = findViewById<View>(R.id.cameraView)
        cameraView.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        val notesView = findViewById<View>(R.id.notesView)
        notesView.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }


    }
}