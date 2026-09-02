package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var age: EditText
    lateinit var signupButton: Button
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.edtName)
        email = findViewById(R.id.edtEmail)
        phone = findViewById(R.id.edtPhone)
        username = findViewById(R.id.edtUsername)
        password = findViewById(R.id.edtPassword)
        age = findViewById(R.id.edtAge)

        signupButton = findViewById(R.id.btnSignup)
        loginButton = findViewById(R.id.btnLogin)

        signupButton.setOnClickListener {

            val preferences = getSharedPreferences(
                "UserData",
                MODE_PRIVATE
            )

            val editor = preferences.edit()

            editor.putString("name", name.text.toString())
            editor.putString("email", email.text.toString())
            editor.putString("phone", phone.text.toString())
            editor.putString("username", username.text.toString())
            editor.putString("password", password.text.toString())
            editor.putString("age", age.text.toString())

            editor.apply()

            Toast.makeText(
                this,
                "Sign Up Successful",
                Toast.LENGTH_SHORT
            ).show()
        }

        loginButton.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}