package com.example.registerclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainClassList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)
        val swDegreeCert = findViewById<Switch>(R.id.swDegreeCert)
        val spnDegree = findViewById<Spinner>(R.id.spnDegree)
        val spnCertificate = findViewById<Spinner>(R.id.spnCertificate)
        val txtCertificate = findViewById<TextView>(R.id.lblCertificate)
        val txtDegree = findViewById<TextView>(R.id.lblDegree)
        val btnNext = findViewById<Button>(R.id.btnNext)

        val firstName = findViewById<EditText>(R.id.txtFirstName)
        val lastName = findViewById<EditText>(R.id.txtLastName)
        val phone = findViewById<EditText>(R.id.txtPhone)

        val spMonth = findViewById<Spinner>(R.id.spnMonth)
        val txtDay = findViewById<EditText>(R.id.txtDay)
        val txtYear = findViewById<EditText>(R.id.txtYear)

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE
            } else {
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                var doBirth = ""
                doBirth = spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                // old way
                // startActivity(new Intent(MainClassList.this, ChooseClass.class));

                //new way
                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if (spnDegree.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())

                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }
                //Start Activity
                startActivity(nextScreen)
            }
        }
    }


    private fun checkData(): Boolean {
        val firstName = findViewById<EditText>(R.id.txtFirstName)
        val lastName = findViewById<EditText>(R.id.txtLastName)
        val phone = findViewById<EditText>(R.id.txtPhone)
        val txtDay = findViewById<EditText>(R.id.txtDay)
        val txtYear = findViewById<EditText>(R.id.txtYear)


        if (firstName.text.toString().isEmpty()) {
            //error
            firstName.error = "Invalid First Name"
            firstName.requestFocus()
            return false
        }

        if (lastName.text.toString().isEmpty()) {
            lastName.error = "Invalid Last Name"
            lastName.requestFocus()
            return false
        }

        if (phone.text.toString().isEmpty()) {
            phone.error = "Invalid Phone Number"
            phone.requestFocus()
            return false
        }

        if (txtDay.text.toString().isEmpty()) {
            txtDay.error = "Invalid Date Selection"
            txtDay.requestFocus()
            return false
        }
        if (txtYear.text.toString().isEmpty()) {
            txtYear.error = "Invalid Date Selection"
            txtYear.requestFocus()
            return false
        }

        return true
    }
}