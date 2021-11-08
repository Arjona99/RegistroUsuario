package com.example.registrousuario

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.os.Bundle
import android.view.Window
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var day = 0;
    var month = 0;
    var year = 0;

    // View elements
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etAccountNumber: EditText? = null
    var etBirthDate: EditText? = null
    var btNext: Button? = null
    var btClear: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature((Window.FEATURE_NO_TITLE));
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)

        // View Elements
        etName = findViewById<EditText>(R.id.name)
        etEmail = findViewById<EditText>(R.id.email)
        etAccountNumber = findViewById<EditText>(R.id.accountNumber)
        etBirthDate = findViewById<EditText>(R.id.birthDate)
        btNext = findViewById<Button>(R.id.bt_next)
        btClear = findViewById<Button>(R.id.bt_clear)

        etBirthDate?.setOnClickListener{showDatePickerDialog()}


    }

    fun clickClean ( view: View) {
        etName?.setText("")
        etEmail?.setText("")
        etAccountNumber?.setText("")
        etBirthDate?.setText("")
    }

    fun clickNext (view: View) {
        if (checkAllFields()) {
            val i = Intent(this@MainActivity, ShowUserData::class.java)
            startActivity(i)
        }
    }

    private fun checkAllFields (): Boolean {
        if (etName?.length() == 0) {
            etName?.setError("This field is required")
            return false
        }
        if (etEmail?.length() == 0) {
            etEmail?.setError("This field is required")
            return false
        }
        if (etAccountNumber?.length() == 0) {
            etAccountNumber?.setError("This field is required")
            return false
        }
        if (etBirthDate?.length() == 0) {
            etBirthDate?.setError("This field is required")
            return false
        }
        return true
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