package com.example.registrousuario

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.util.Patterns
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    var isValid = false

    var day = 0
    var month = 0
    var year = 0

    // View elements
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etAccountNumber: EditText? = null
    var etBirthDate: EditText? = null
    var btNext: Button? = null
    var btClear: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature((Window.FEATURE_NO_TITLE))
        getSupportActionBar()?.hide()
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
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

    fun clickClean () {
        etName?.setText("")
        etEmail?.setText("")
        etAccountNumber?.setText("")
        etBirthDate?.setText("")
    }

    fun clickNext () {
        if (checkAllFields()) {
            val intent = Intent(this, ShowUserData::class.java)

            //Sending parameters
            val usuario = Usuario(etName?.getText().toString(), etAccountNumber?.getText().toString(), etEmail?.getText().toString(), this.day, this.month, this.year)
            val parameters = Bundle()
            parameters.putParcelable("usuario", usuario)
            intent.putExtras(parameters)

            startActivity(intent)
        }
    }

    private fun checkAllFields (): Boolean {
        var isValid = true
        fun  isValidEmail(str: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(str).matches()
        }

        if (etName?.length() == 0) {
            etName?.setError(getString(R.string.inputError))
            isValid = false
        }
        if (!isValidEmail(etEmail?.getText().toString())) {
            etEmail?.setError(getString(R.string.inputError))
            isValid = false
        }
        if (etAccountNumber?.length() !== 9) {
            etAccountNumber?.setError(getString(R.string.inputError))
            isValid = false
        }
        if (etBirthDate?.length() == 0) {
            etBirthDate?.setError(getString(R.string.inputError))
            isValid = false
        }
        return isValid
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month + 1, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        this.day = day
        this.month = month
        this.year = year
        etBirthDate.setText("$day/$month/$year")
    }

}