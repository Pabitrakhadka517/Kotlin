package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework)

        // References to TextViews
        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewGender = findViewById<TextView>(R.id.textViewGender)
        val textViewCountry = findViewById<TextView>(R.id.textViewCountry)
        val textViewCity = findViewById<TextView>(R.id.textViewCity)

        // Get data from Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: "Not Provided"
        val email = intent.getStringExtra("EMAIL") ?: "Not Provided"
        val gender = intent.getStringExtra("GENDER") ?: "Not Specified"
        val country = intent.getStringExtra("COUNTRY") ?: "Not Provided"
        val city = intent.getStringExtra("CITY") ?: "Not Provided"

        // Set data to TextViews
        textViewWelcome.text = "Welcome $fullName"
        textViewEmail.text = "Email: $email"
        textViewGender.text = "Gender: $gender"
        textViewCountry.text = "Country: $country"
        textViewCity.text = "City: $city"
    }
}
