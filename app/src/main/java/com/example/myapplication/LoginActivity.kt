package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.edtLoginUsername)
        password = findViewById(R.id.edtLoginPassword)
        loginButton = findViewById(R.id.btnLogin)

        loginButton.setOnClickListener {

            val preferences = getSharedPreferences("UserData", MODE_PRIVATE)

            val savedUsername = preferences.getString("username", "")

            val savedPassword = preferences.getString("password", "")

            if (username.text.toString() == savedUsername &&
                password.text.toString() == savedPassword) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Credentials don't match , Login Unsuccessful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}