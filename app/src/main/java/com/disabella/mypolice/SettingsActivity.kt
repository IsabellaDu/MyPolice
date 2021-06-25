package com.disabella.mypolice

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchView = findViewById<View>(R.id.switchView)

        val settingsLayout = findViewById<View>(R.id.settingsLayout)

        switchView.setOnClickListener(View.OnClickListener { v ->
            val checked = (v as Switch).isChecked
            if (checked) {
                settingsLayout.setBackgroundColor(Color.BLACK)
                intent.putExtra("mainLayout", "BLACK")

            } else {
                settingsLayout.setBackgroundColor(Color.WHITE)
                intent.putExtra("mainLayout", "WHITE")
            }
        })

        val buttonBack = findViewById<View>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}