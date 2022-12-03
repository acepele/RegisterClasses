package com.example.registerclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess private constructor(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById(R.id.idLoginText) as TextView
        val txtPassword = findViewById(R.id.idPasswordText) as TextView
        val btnLogin = findViewById(R.id.btnLogin) as Button

        btnLogin.setOnClickListener {
            val toastError: Toast? = null
            val isOK: LoginSuccess? = null

            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                MainActivity.LoginSuccess.login -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessageLogin), toastError.LENGTH_SHORT).show()
                    txtLogin.requestFocus()
                }
                MainActivity.LoginSuccess.password -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show()
                    txtPassword.requestFocus()
                }
                else ->
                    startActivity(Intent(this@MainActivity, MainClassList::class.java))
            }
        }


    }


    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Aljeda"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }

        return if (holdPass != txtPassword) {
            LoginSuccess.password
        } else LoginSuccess.success

    }
}