package com.example.registrousuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    object userData {
        var name = "";
        var email = "";
        var accountNumber = "";
        object birthDate {
            var day = 0;
            var month = 0;
            var year = 0;
        }
    }

    var day = 0;
    var month = 0;
    var year = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature((Window.FEATURE_NO_TITLE));
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
        var etBirthDate = findViewById<EditText>(R.id.birthDate)
        etBirthDate.setOnClickListener{showDatePickerDialog()}

    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        this.day = day
        this.month = month
        this.year = year
        var etBirthDate = findViewById<EditText>(R.id.birthDate)
        etBirthDate.setText("$day/$month/$year")
    }
}