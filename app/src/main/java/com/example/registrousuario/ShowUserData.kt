package com.example.registrousuario

import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class ShowUserData : AppCompatActivity() {

    var tvName: TextView? = null
    var tvEmail: TextView? = null
    var tvAccountNumber: TextView? = null
    var tvAge: TextView? = null
    var tvAnimal: TextView? = null
    var titleUserName: TextView? = null
    var imageAnimal: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature((Window.FEATURE_NO_TITLE))
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_user_data)

        // Getting user info
        val bundle = intent.extras
        val usuario = bundle?.getParcelable<Usuario>("usuario")
        val day = usuario?.day
        val month = usuario?.month
        val year = usuario?.year
        val animal = getChineseInfo(year)
        val firstName = usuario?.name?.split(" ")?.get(0)

        // View Elements
        tvName = findViewById<TextView>(R.id.tvName)
        tvEmail = findViewById<TextView>(R.id.tvEmail)
        tvAccountNumber = findViewById<TextView>(R.id.tvAccountNumber)
        tvAge = findViewById<TextView>(R.id.tvAge)
        tvAnimal = findViewById<TextView>(R.id.tvAnimal)
        titleUserName = findViewById<TextView>(R.id.titleUserName)
        imageAnimal = findViewById<ImageView>(R.id.ivAnimal)

        // Setting user info
        titleUserName?.text = getString(R.string.title_welcome, firstName)
        tvName?.text = usuario?.name
        tvAge?.text = this.getAge(day, month, year)
        tvAccountNumber?.text = usuario?.accountNumber
        tvEmail?.text = usuario?.email
        tvAnimal?.text = getString(getAnimalString(animal))
        imageAnimal?.setBackgroundResource(getAnimalImage(animal))
        imageAnimal?.contentDescription = getString(getAnimalString(animal))

    }

    private fun getAge(day: Int?, month: Int?, year: Int?): String {
        val dob: Calendar = Calendar.getInstance()
        val today: Calendar = Calendar.getInstance()

        if (day != null && month != null && year != null) {
            dob.set(year, month, day)
        }

        var age: Int = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--
        }

        val ageInt = age

        return ageInt.toString()
    }

    private fun getChineseInfo(year: Int?): String? {
        val map = mutableMapOf<Int,String>()
        map[0] = "monkey"
        map[1] = "rooster"
        map[2] = "dog"
        map[3] = "pig"
        map[4] = "rat"
        map[5] = "ox"
        map[6] = "tiger"
        map[7] = "rabbit"
        map[8] = "dragon"
        map[9] = "snake"
        map[10] = "horse"
        map[11] = "goat"

        if (year != null) {
            val remainder = year % 12

            return map[remainder]
        }

        return ""
    }

    private fun getAnimalString(animal: String?): Int {
        val id = resources.getIdentifier(animal, "string", "com.example.registrousuario")
        return id
    }

    private fun getAnimalImage(animal: String?): Int {
        val id = resources.getIdentifier(animal, "drawable", "com.example.registrousuario")
        return id
    }
}