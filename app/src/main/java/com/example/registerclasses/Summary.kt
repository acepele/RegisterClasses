package com.example.registerclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Summary : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCert: String? = ""
    private var class1: String? = ""
    private var selected1: String? = ""
    private var class2: String? = ""
    private var selected2: String? = ""
    private var class3: String? = ""
    private var selected3: String? = ""
    private var class4: String? = ""
    private var selected4: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras
        if (extras != null) {
            firstName = extras.getString("FirstName")
            lastName = extras.getString("LastName")
            phone = extras.getString("Phone")
            birthDate = extras.getString("BirthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCert = extras.getString("degreeCert")
            class1 = extras.getString("Class1")
            selected1 = extras.getString("Selected1")
            class2 = extras.getString("Class2")
            selected2 = extras.getString("Selected2")
            class3 = extras.getString("Class3")
            selected3 = extras.getString("Selected3")
            class4 = extras.getString("Class4")
            selected4 = extras.getString("Selected4")

        }

        val txtStudent = findViewById<TextView>(R.id.txtStudent)
        val txtPhone = findViewById<TextView>(R.id.txtPhone)
        val txtBirthDate = findViewById<TextView>(R.id.txtBirthDate)
        val txtDegreePlan = findViewById<TextView>(R.id.txtDegree)
        val txtMajor = findViewById<TextView>(R.id.txtMajor)
        val txtClassSchedule = findViewById<TextView>(R.id.txtClassSchedule)

        txtStudent.text = "$firstName $lastName"
        txtPhone.text = phone
        txtBirthDate.text = birthDate
        txtDegreePlan.text = isDegreeCert
        txtMajor.text = degreeCert

        val ClassSchedule = StringBuilder(250)
        if (class1 != "") {
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        if (class2 != "") {
            ClassSchedule.append(class2 + "\n" + selected2 + "\n\n")
        }
        if (class3 != "") {
            ClassSchedule.append(class3 + "\n" + selected3 + "\n\n")
        }
        if (class4 != "") {
            ClassSchedule.append(class4 + "\n" + selected4 + "\n\n")
        }


        txtClassSchedule.text = ClassSchedule

    }
}