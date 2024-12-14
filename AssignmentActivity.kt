package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AssignmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)

        // References to views
        val editTextFullName = findViewById<EditText>(R.id.editTextFullName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        val autoCompleteCity = findViewById<AutoCompleteTextView>(R.id.autoCompleteCity)
        val checkBoxTerms = findViewById<CheckBox>(R.id.checkBoxTerms)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        // Country Dropdown Setup
        val countries = arrayOf("Nepal", "India", "USA", "UK")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        spinnerCountry.adapter = countryAdapter

        // City AutoComplete Setup
        val cities = arrayOf("Kathmandu", "Pokhara", "Delhi", "New York", "London")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        autoCompleteCity.setAdapter(cityAdapter)

        // Submit Button Click Listener
        buttonSubmit.setOnClickListener {
            if (checkBoxTerms.isChecked) {
                // Retrieve input values
                val fullName = editTextFullName.text.toString()
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                val selectedGenderId = radioGroupGender.checkedRadioButtonId
                val gender = if (selectedGenderId != -1) {
                    findViewById<RadioButton>(selectedGenderId).text.toString()
                } else {
                    "Not Specified"
                }
                val country = spinnerCountry.selectedItem.toString()
                val city = autoCompleteCity.text.toString()

                // Pass data to HomeworkActivity
                val intent = Intent(this, HomeworkActivity::class.java).apply {
                    putExtra("FULL_NAME", fullName)
                    putExtra("EMAIL", email)
                    putExtra("GENDER", gender)
                    putExtra("COUNTRY", country)
                    putExtra("CITY", city)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
