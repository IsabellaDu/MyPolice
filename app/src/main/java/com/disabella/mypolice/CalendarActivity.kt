package com.disabella.mypolice

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


@Suppress(
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class CalendarActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)


        val dateOfComing = findViewById<EditText>(R.id.date_of_coming)
        val textViewCount = findViewById<TextView>(R.id.textview_count)
        val buttonCount = findViewById<Button>(R.id.button_count)
        val df: DateFormat = SimpleDateFormat("dd.MM.yyyy")
        val date: String = df.format(Calendar.getInstance().time)

        val todaysDate = df.parse(date)
        val dateOfComingToDate = df.parse(dateOfComing.text.toString())

        val difference: Long = todaysDate.time - dateOfComingToDate.time
        val days =
            (difference / (24 * 60 * 60 * 1000)).toInt() // миллисекунды / (24ч * 60мин * 60сек * 1000мс)

        buttonCount.setOnClickListener {
            var amountOfDays = 0
            when {
                days > 90 -> {
                    amountOfDays = days - 90
                    textViewCount.text = "This VISA expired $amountOfDays days ago"
                }
                days == 90 -> {
                    textViewCount.text = "This visa will expire tomorrow"
                }
                else -> {
                    amountOfDays = days - 90
                    textViewCount.text = "This VISA will expire in $amountOfDays days"
                }
            }
        }
    }
}


