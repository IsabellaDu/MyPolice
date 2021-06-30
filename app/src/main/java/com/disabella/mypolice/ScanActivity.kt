package com.disabella.mypolice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ScanActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        val licensePlate = findViewById<EditText>(R.id.license_plate)
        val buttonCheck = findViewById<Button>(R.id.button_check)
        val textViewCheck = findViewById<TextView>(R.id.textview_check)

        val listOfRegisteredCars = arrayOf(
            "AS2356KL",
            "GH5682NM",
            "TK7621OT"
        )

        buttonCheck.setOnClickListener {

            if (licensePlate.text.isEmpty()) {
                val toast = Toast.makeText(
                    applicationContext,
                    "First enter the vehicle license plate ",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            } else {
                val result =
                    presenceOfCarInDatabase(listOfRegisteredCars, licensePlate.text.toString())

                if (result == 1) {
                    textViewCheck.text = "This car is registered"
                } else {
                    textViewCheck.text = "This car is not registered"
                }
            }
        }
    }
}

fun presenceOfCarInDatabase(listOfRegisteredCars: Array<String>, licensePlate: String): Int {
    var result = 0
    for (l in 0..listOfRegisteredCars.lastIndex) {
        if (listOfRegisteredCars[l].contains(licensePlate.toUpperCase())) {
            result++
        }
    }
    return result
}